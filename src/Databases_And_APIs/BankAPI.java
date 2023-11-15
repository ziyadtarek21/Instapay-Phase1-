package Databases_And_APIs;

import java.util.HashMap;
import java.util.Map;

public class BankAPI {
    private static Map<String, Double> bankAccountNumbers = new HashMap<String, Double>() {
        {
            put("1234567891011121", 456.1);
            put("2345678910111213", 321.0);
            put("3456789101112111", 56465498.5);
            put("4568976464513545", 53421.0);
            put("5646843213715344", 0.0);
            put("6546464646546448", 6646.0);
        }
    };

    public static boolean checkBankAccount(String accountNumber) {
        return bankAccountNumbers.containsKey(accountNumber);
    }

    public static double returnBalance(String accountNumber) {
        return bankAccountNumbers.get(accountNumber);
    }

    public static void setBalance(String accountNumber, double balance) {
        bankAccountNumbers.put(accountNumber, balance);
    }
    public static boolean receiveMoney(String accNum, Double amount){
        if(amount >= 0 && checkBankAccount(accNum)){
            bankAccountNumbers.put(accNum, bankAccountNumbers.get(accNum) + amount);
            return true;
        }
        System.out.println("this account doesn't exist!");
        return false;
    }


}
