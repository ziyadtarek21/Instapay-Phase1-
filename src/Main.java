import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> mp = new HashMap<>();
        mp.put("a", 5);
        System.out.println(mp.get("a"));
        System.out.println(mp.get("b"));
    }
}