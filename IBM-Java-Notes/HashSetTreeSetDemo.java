import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;

public class HashSetTreeSetDemo {
    public static void main(String[] args) {
        // HashSet: fast, no guaranteed order, one null allowed
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Banana"); // ignored, Banana is already in the set
        System.out.println("Fruits: " + fruits);

        if (fruits.contains("Apple")) {
            System.out.println("Apple is in the set");
        }

        fruits.remove("Cherry"); // no-op, Cherry was never added
        System.out.println("After removing Cherry: " + fruits);

        // TreeSet: sorted order, no nulls, slower than HashSet
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(3); // ignored, 3 is already in the set
        System.out.println("Numbers: " + numbers); // prints in ascending order

        if (numbers.contains(5)) {
            System.out.println("5 is in the set");
        }

        numbers.remove(8); // no-op, 8 was never added
        System.out.println("After removing 8: " + numbers);
    }
}