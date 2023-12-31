package Databases_And_APIs;

import java.util.HashMap;
import java.util.Map;

public class WaterAPI {

    private static Map<String, Double> counterNumbers = new HashMap<String, Double>() {
        {
            put("123", 50.2);
            put("45", 40.3);
            put("78", 40.566);
            put("741", 2.0);
        }
    };

    public static boolean findWaterCounter(String counterNumber) {
        return counterNumbers.containsKey(counterNumber);
    }

    public static Double getAmount(String counterNumber){
        return counterNumbers.get(counterNumber);
    }


    public static void pay(String countNumber) {
        counterNumbers.put(countNumber, 0.0);
    }
}
