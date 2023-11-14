package Transactions;

import UserPack.Account;
import walletProviders.CIBWallet;
import walletProviders.VodafoneWallet;
import walletProviders.WalletProviders;

import java.util.Scanner;

public class PhoneTransfer implements Transfer{

    @Override
    public boolean transfer(Account account, String info) {
        WalletProviders walletProviders;
        if (info.startsWith("010")){
            walletProviders = new VodafoneWallet(info);
        }else{
            walletProviders = new CIBWallet(info);
        }
        System.out.println("enter the amount of money you want to send: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if(input <= account.getBalance()){
            if(walletProviders.receiveMoney(info, input)){
                account.deductMoney(input);
                return true;
            }
            return false;
        }
        return false;
    }
}
