package Databases_And_APIs;

import java.util.HashMap;
import java.util.Map;

public class ElectricityAPI {
    /*
     * احذر حنيكه من ريمو تم جفل counter numbers عباره عن map
     * */
    private static Map<String, Double> counterNumbers = new HashMap<String, Double>() {
        {
            put("123", 120.1);
            put("45", 845.21);
            put("78", 20.0);
            put("741", 741.2);
        }
    };

    public static boolean findElectricityCounter(String counterNumber) {
        return counterNumbers.containsKey(counterNumber);
    }

    public static Double getAmount(String counterNumber){
        return counterNumbers.get(counterNumber);
    }

    public static void pay(String counterNumber){
        counterNumbers.put(counterNumber, 0.0);
    }

}
