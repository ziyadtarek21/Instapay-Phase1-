package Transactions;

import Databases_And_APIs.BankAPI;
import Databases_And_APIs.SystemDatabase;
import UserPack.Account;

import java.util.Scanner;

public class AccountTransfer implements Transfer{
    public boolean transfer(Account account, String info) {
        System.out.println("enter the amount of money you want to send: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if(input <= account.getBalance())
            return SystemDatabase.receiveMoney(info, input);
        else return false;
    }
}
