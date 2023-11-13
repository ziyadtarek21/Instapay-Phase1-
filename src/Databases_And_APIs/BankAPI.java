package Databases_And_APIs;

import java.util.HashMap;
import java.util.Map;

public class BankAPI {
    private static Map<String, Double> bankAccountNumbers = new HashMap<>() {
        {
            put("1", 456.1);
            put("2", 321.0);
            put("3", 56465498.5);
            put("4", 53421.0);
            put("5", 0.0);
            put("6", 6646.0);
        }
    };

    public static boolean checkBankAccount(String accountNumber) {
        return bankAccountNumbers.containsKey(accountNumber);
    }
    /*
     * احذر حنيكه من ريمو تم اضافه function
     * */
    public static boolean receiveMoney(String accNum, Double amount){
        if(amount >= 0 && checkBankAccount(accNum)){
            bankAccountNumbers.put(accNum, bankAccountNumbers.get(accNum) + amount);
            return true;
        }
        System.out.println("this account doesn't exist!");
        return false;
    }
}
