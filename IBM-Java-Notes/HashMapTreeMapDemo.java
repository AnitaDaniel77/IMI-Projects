import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class HashMapTreeMapDemo {
    public static void main(String[] args) {
        // HashMap: fast, no guaranteed order, one null key allowed
        Map<String, Integer> wordCounts = new HashMap<>();
        wordCounts.put("the", 1);
        wordCounts.put("cat", 1);
        wordCounts.put("the", wordCounts.get("the") + 1); // "the" seen again, bump the count

        for (String key : wordCounts.keySet()) {
            System.out.println(key + ": " + wordCounts.get(key));
        }

        if (wordCounts.containsKey("cat")) {
            System.out.println("cat is in the map");
        }

        wordCounts.remove("cat");
        System.out.println("After removing cat: " + wordCounts);

        // TreeMap: sorted by key, no null key allowed, slower than HashMap
        Map<String, Integer> scores = new TreeMap<>();
        scores.put("Alice", 90);
        scores.put("Bob", 75);
        scores.put("Charlie", 85);

        for (String key : scores.keySet()) { // always comes out in key order
            System.out.println(key + ": " + scores.get(key));
        }

        if (scores.containsKey("Bob")) {
            System.out.println("Bob is in the map");
        }

        scores.remove("Bob");
        System.out.println("After removing Bob: " + scores);
    }
}