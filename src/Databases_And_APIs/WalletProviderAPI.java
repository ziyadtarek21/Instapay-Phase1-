package Databases_And_APIs;

import java.util.ArrayList;
import java.util.List;

public class WalletProviderAPI {

    static List<String> PhoneNumbers = new ArrayList<>() {
        {
            add("01091820070");
            add("01210203045");
            add("01146519812");
            add("01589191265");
        }
    };

    public static boolean verifyPhoneNumber(String accountNumber) {
        return PhoneNumbers.contains(accountNumber);
    }


}
