package Transactions;

import Databases_And_APIs.WalletProviderAPI;

public class PhoneTransfer implements Transfer{
    public boolean transfer(Account account, String info) {
        System.out.println("enter the amount of money you want to send: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if(input <= account.getBalance())
            return WalletProviderAPI.receiveMoney(info, input);
        else return false;
    }
}
