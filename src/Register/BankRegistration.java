package Register;

import Databases_And_APIs.BankAPI;
import Databases_And_APIs.SystemDatabase;
import UserPack.Account;
import UserPack.BankAcc;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BankRegistration implements RegistrationStrategy{

    @Override
    public boolean register(Account acc) {
        Scanner scanner = new Scanner(System.in);

        String accountNumber;
        do {
            System.out.println("Please enter your account number:");
            accountNumber = scanner.nextLine();
            if(accountNumber.equals("1")){
                return false;
            }
            if(BankAPI.checkBankAccount(accountNumber)){

                if(Pattern.matches("\\d+", accountNumber) && (accountNumber.length() == 16)){
                    break;
                }else{
                    System.out.println("Please make sure the account number is 16 digits long");
                }
            }
            else {
                System.out.println("The number you have entered is not valid. Please try again or enter 1 to cancel");
            }

        }while(true);

        double balance = BankAPI.returnBalance(accountNumber);
        acc.setBalance(balance);
        BankAcc acc1 = new BankAcc(acc.getUsername(), acc.getPassword(), balance, acc.getUser());
        acc1.setCardNumber(accountNumber);
        acc1.getUser().setAcc(acc1);
        SystemDatabase.addUser(acc1.getUser());
        return true;
    }
}
