package Transactions;

import Databases_And_APIs.BankAPI;
import Databases_And_APIs.SystemDatabase;
import UserPack.Account;
import UserPack.WalletAcc;

import java.util.Scanner;

public class AccountTransfer implements Transfer{
    public boolean transfer(Account account, String info) {
        System.out.println("enter the amount of money you want to send: ");
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        if(input <= account.getBalance()){

            if(account instanceof WalletAcc){
                if(SystemDatabase.receiveMoney(info, input,true)) {
                    account.deductMoney(input);
                    return true;
                }
            }
            else{
                account.deductMoney(input);
                return SystemDatabase.receiveMoney(info, input,false);
            }
        }

        return false;
    }
}
