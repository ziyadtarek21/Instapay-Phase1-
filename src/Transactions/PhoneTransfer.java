package Transactions;

import Databases_And_APIs.WalletProviderAPI;
import UserPack.Account;

import java.util.Scanner;

public class PhoneTransfer implements Transfer{

    @Override
    public boolean transfer(Account account, String info) {
        System.out.println("enter the amount of money you want to send: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if(input <= account.getBalance())
            return WalletProviderAPI.receiveMoney(info, input);
        else return false;
    }
}
