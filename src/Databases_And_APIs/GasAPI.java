package Databases_And_APIs;

import java.util.HashMap;
import java.util.Map;

public class GasAPI {

    private static Map<String, Double> counterNumbers = new HashMap<String, Double>() {
        {
            put("123", 9874.2);
            put("45", 3215.23);
            put("78", 7465.865);
            put("741", 46.45);
        }
    };

    public static boolean findGasCounter(String counterNumber) {
        return counterNumbers.containsKey(counterNumber);
    }

    public static Double getAmount(String counterNumber){
        return counterNumbers.get(counterNumber);
    }


    public static void pay(String counterNumber) {
        counterNumbers.put(counterNumber, 0.0);
    }
}

