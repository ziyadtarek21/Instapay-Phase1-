package Register;

import Databases_And_APIs.SystemDatabase;
import UserPack.Account;
import UserPack.BankAcc;
import UserPack.User;
import UserPack.WalletAcc;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegistrationManager {
    private OTP otp = new OTP();

    public boolean doRegister(){

        Scanner scanner = new Scanner(System.in);
        Account acc;
        RegistrationStrategy registerS;


        System.out.println("Enter your information:");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();

        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();

        String phoneNumber;
        do {
            System.out.print("Phone Number: ");
            phoneNumber = scanner.nextLine();
            if(Pattern.matches("\\d+", phoneNumber) && (phoneNumber.length() == 11)){
                break;
            }
            else{
                System.out.println("Please make sure the phone number is 11 digits only");
            }
        }while (true);


        String random = otp.randomGenerate();
        boolean verified = otp.sendOTP(random);

        if (verified){
            System.out.println("The phone number has been verified successfully");
        }
        else {
            System.out.println("Verification process failed. Registration aborted");
            return false;
        }

        String ssn = Integer.toString((int)System.currentTimeMillis());

        User user = new User(firstName, lastName, phoneNumber, ssn);

        String username;
        do {
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            if(username.equals("1")){
                System.out.println("Registration aborted");
                return false;
            }
            if(SystemDatabase.checUsername(username)){
                System.out.println("Username already exist. Please type something else or enter 1 to cancel");
            }
            else {
                break;
            }
        } while (true);

        String password;
        do {
            System.out.print("Enter password: ");
            password = scanner.nextLine();

            System.out.print("Confirm password: ");
            String confirmPassword = scanner.nextLine();


            if (!password.equals(confirmPassword)) {
                System.out.println("Password confirmation failed. Please try again");
            }
            else {
                break;
            }

        } while (true);


        boolean state;
        do {
            System.out.println("What type of account are willing to have?");
            System.out.println("1. Wallet Account");
            System.out.println("2. Bank Account");
            System.out.println("3. Cancel Registration");

            Integer choice = scanner.nextInt();

            if(choice.equals(1)){
                acc = new WalletAcc(username, password, 0, user);
                registerS = new WalletRegistration();
                state = registerS.register(acc);
                break;
            } else if (choice.equals(2)) {
                acc = new BankAcc(username, password, 0, user);
                registerS = new BankRegistration();
                state = registerS.register(acc);
                break;
            } else if (choice.equals(3)) {
                System.out.println("Registration Aborted");
                state = false;
                break;
            }else {
                System.out.println("Invalid choice, please check the available options");
            }
        }while (true);

        if (state){
            System.out.println("Your account has been created successfully");
            return true;
        }
        else {
            System.out.println("Failed to register the account");
            return false;
        }
    }
}
