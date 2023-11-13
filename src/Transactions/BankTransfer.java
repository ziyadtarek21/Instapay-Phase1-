package Transactions;

import Databases_And_APIs.BankAPI;
import UserPack.Account;

import java.util.Scanner;

public class BankTransfer implements Transfer{
    public boolean transfer(Account account, String info) {
        System.out.println("enter the amount of money you want to send: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if(input <= account.getBalance())
            return BankAPI.receiveMoney(info, input);
        else return false;
    }
}
