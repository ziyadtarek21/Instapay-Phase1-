package Databases_And_APIs;

import java.util.ArrayList;
import java.util.List;

public class BankAPI {
    static List<String> bankAccountNumbers = new ArrayList<>() {
        {
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
        }
    };

    public static boolean checkBankAccount(String accountNumber) {
        return bankAccountNumbers.contains(accountNumber);
    }
}
