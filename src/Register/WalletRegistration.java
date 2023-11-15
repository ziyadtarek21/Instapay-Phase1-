package Register;


import Databases_And_APIs.SystemDatabase;
import UserPack.Account;
import UserPack.WalletAcc;
import walletProviders.CIBWallet;
import walletProviders.VodafoneWallet;
import walletProviders.WalletProviders;

import java.util.Scanner;

public class WalletRegistration implements RegistrationStrategy{
    @Override
    public boolean register(Account acc) {
        Scanner scanner = new Scanner(System.in);
        WalletProviders walletProviders = null;


        boolean done = false;
        do {
            System.out.println("Choose your service provider (1 for Vodafone, 2 for CIB):");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    walletProviders = new VodafoneWallet(acc.getUser().getPhoneNumber());
                    done = true;
                    break;
                case 2:
                    walletProviders = new CIBWallet("CIB" + acc.getUser().getPhoneNumber());
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1 or 2.");
            }
        } while (!done);


        if(!walletProviders.verifyPhoneNumber(acc.getUser().getPhoneNumber())){
            System.out.println("There is no wallet registered on the entered phone number");
            return false;
        }

        double balance = walletProviders.returnBalance(acc.getUser().getPhoneNumber());
        acc.setBalance(balance);
        WalletAcc acc1 = new WalletAcc(acc.getUsername(), acc.getPassword(), balance, acc.getUser());
        acc1.setServiceprovider(walletProviders);
        acc1.getUser().setAcc(acc1);
        SystemDatabase.addUser(acc1.getUser());
        return true;
    }
}
