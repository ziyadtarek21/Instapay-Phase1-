import Register.RegistrationManager;
import UserPack.Account;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome to our Instapay clone");
        boolean signedIn = false;
        Account signedAcc = null;
        while (true){
            if(!signedIn){
                Scanner scanner = new Scanner(System.in);
                System.out.println("do you want to sign in or login ?");
                System.out.println("1.register");
                System.out.println("2.login ");
                int x = scanner.nextInt();
                if(x == 1){
                    RegistrationManager registrationManager = new RegistrationManager();
                    registrationManager.doRegister();
                } else if (x == 2){

                } else {
                    System.out.println("nigga choose right num");
                }
            }
        }
    }
}