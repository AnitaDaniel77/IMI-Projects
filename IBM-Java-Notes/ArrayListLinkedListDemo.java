import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListDemo {
    public static void main(String[] args) {
        // ArrayList: dynamic array, fast get-by-index, slower insert/remove
        List<String> shoppingList = new ArrayList<>();
        shoppingList.add("Milk");
        shoppingList.add("Bread");
        shoppingList.add("Eggs");
        System.out.println("Shopping list: " + shoppingList);

        String firstItem = shoppingList.get(0); // jumps straight to index 0
        System.out.println("First item: " + firstItem);

        shoppingList.remove("Bread"); // shifts remaining elements up
        System.out.println("After removing Bread: " + shoppingList);

        // LinkedList: doubly linked nodes, fast insert/remove, slower get-by-index
        LinkedList<String> undoHistory = new LinkedList<>();
        undoHistory.add("Typed heading");
        undoHistory.add("Added image");
        undoHistory.add("Changed font");
        System.out.println("Undo history: " + undoHistory);

        undoHistory.removeLast(); // quick, just unlinks the last node
        System.out.println("After undo: " + undoHistory);

        undoHistory.addFirst("Opened document"); // quick, relinks the front node
        System.out.println("After adding to front: " + undoHistory);
    }
}