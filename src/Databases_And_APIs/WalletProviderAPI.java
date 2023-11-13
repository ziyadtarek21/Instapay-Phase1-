package Databases_And_APIs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletProviderAPI {


     private static Map<String, Double> PhoneNumbers = new HashMap<>() {
        {
            put("01091820070", 456.1);
            put("01210203045", 321.0);
            put("01146519812", 56465498.5);
            put("01589191265", 53421.0);
        }
    };

    public static boolean verifyPhoneNumber(String accountNumber) {
        return PhoneNumbers.containsKey(accountNumber);
    }
    /*
     * احذر حنيكه من ريمو تم اضافه function
     * */
    public static boolean receiveMoney(String phoneNum, Double amount){
        if(amount >= 0 && verifyPhoneNumber(phoneNum)){
            PhoneNumbers.put(phoneNum, PhoneNumbers.get(phoneNum) + amount);
            return true;
        }
        System.out.println("this account doesn't exist!");
        return false;
    }
}
