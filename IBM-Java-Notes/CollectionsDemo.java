import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;

public class CollectionsDemo {
    public static void main(String[] args) {
        // List: ordered, duplicates allowed, backed by a dynamic array
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("Fruits: " + fruits);

        String firstFruit = fruits.get(0); // fast random access on an ArrayList
        System.out.println("First fruit: " + firstFruit);

        // LinkedList: same List interface, but quick inserts/removals instead of fast lookups
        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");
        System.out.println("Animals: " + animals);

        // Set: no duplicates allowed
        Set<String> colors = new HashSet<>();
        colors.add("Red");
        colors.add("Green");
        colors.add("Blue");
        colors.add("Red"); // ignored, Red is already in the set
        System.out.println("Colors: " + colors);

        // Map: unique keys mapped to values
        Map<String, Integer> ageMap = new HashMap<>();
        ageMap.put("Alice", 30);
        ageMap.put("Bob", 25);
        ageMap.put("Charlie", 35);
        System.out.println("Age Map: " + ageMap);

        int aliceAge = ageMap.get("Alice"); // look up a value by its key
        System.out.println("Alice's Age: " + aliceAge);
    }
}