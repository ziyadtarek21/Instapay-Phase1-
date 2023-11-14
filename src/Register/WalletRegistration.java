package Register;


import Databases_And_APIs.SystemDatabase;
import Databases_And_APIs.WalletProviderAPI;
import UserPack.Account;
import UserPack.WalletAcc;

import java.util.Scanner;

public class WalletRegistration implements RegistrationStrategy{
    @Override
    public boolean register(Account acc) {
        Scanner scanner = new Scanner(System.in);


        if(!WalletProviderAPI.verifyPhoneNumber(acc.getUser().getPhoneNumber())){
            System.out.println("There is no wallet registered on the entered phone number");
            return false;
        }
        System.out.println("Enter your service Provider");
        String sProvider = scanner.nextLine();

        double balance = WalletProviderAPI.returnBalance(acc.getUser().getPhoneNumber());
        acc.setBalance(balance);
        WalletAcc acc1 = new WalletAcc(acc.getUsername(), acc.getPassword(), balance, acc.getUser());
        acc1.setServiceprovider(sProvider);
        SystemDatabase.addUser(acc1.getUser());
        return true;
    }
}
