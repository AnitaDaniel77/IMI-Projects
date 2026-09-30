import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// library management: ArrayList, dynamic resizing as books come in
class Library {
    private List<String> books = new ArrayList<>();

    void addBook(String title) {
        books.add(title);
    }

    void displayBooks() {
        for (String book : books) {
            System.out.println(book);
        }
    }
}

// e-commerce orders: HashMap, fast lookup by order ID
class OrderSystem {
    private Map<String, String> orders = new HashMap<>();

    void addOrder(String orderId, String customerName) {
        orders.put(orderId, customerName);
    }

    void displayOrders() {
        for (String orderId : orders.keySet()) {
            System.out.println(orderId + ": " + orders.get(orderId));
        }
    }
}

// employee records: HashSet, blocks duplicate names automatically
class EmployeeSystem {
    private Set<String> employees = new HashSet<>();

    void addEmployee(String name) {
        employees.add(name); // duplicate name is just ignored
    }

    void displayEmployees() {
        for (String name : employees) {
            System.out.println(name);
        }
    }
}

// task management: LinkedList, efficient add/remove as tasks come and go
class TaskManager {
    private LinkedList<String> tasks = new LinkedList<>();

    void addTask(String task) {
        tasks.add(task);
    }

    String completeTask() {
        return tasks.removeFirst(); // finishes and removes the oldest task
    }

    void displayTasks() {
        for (String task : tasks) {
            System.out.println(task);
        }
    }
}

// social media followers: HashMap of HashSets, unique followers per user
class FollowerSystem {
    private Map<String, Set<String>> followers = new HashMap<>();

    void addFollower(String user, String follower) {
        followers.computeIfAbsent(user, k -> new HashSet<>()).add(follower); // duplicate follower is ignored
    }

    void displayFollowers(String user) {
        Set<String> userFollowers = followers.get(user);
        if (userFollowers != null) {
            for (String follower : userFollowers) {
                System.out.println(follower);
            }
        }
    }
}

public class CollectionsRealWorldDemo {
    public static void main(String[] args) {
        System.out.println("--- Library ---");
        Library library = new Library();
        library.addBook("1984");
        library.addBook("Brave New World");
        library.displayBooks();

        System.out.println("--- Orders ---");
        OrderSystem orders = new OrderSystem();
        orders.addOrder("ORD1", "Anita");
        orders.addOrder("ORD2", "Thabo");
        orders.displayOrders();

        System.out.println("--- Employees ---");
        EmployeeSystem employees = new EmployeeSystem();
        employees.addEmployee("Anita");
        employees.addEmployee("Anita"); // ignored, already added
        employees.addEmployee("Sipho");
        employees.displayEmployees();

        System.out.println("--- Tasks ---");
        TaskManager tasks = new TaskManager();
        tasks.addTask("Write report");
        tasks.addTask("Review PR");
        System.out.println("Completed: " + tasks.completeTask());
        tasks.displayTasks();

        System.out.println("--- Followers ---");
        FollowerSystem followerSystem = new FollowerSystem();
        followerSystem.addFollower("anita77", "thabo_m");
        followerSystem.addFollower("anita77", "sipho_k");
        followerSystem.addFollower("anita77", "thabo_m"); // ignored, already a follower
        followerSystem.displayFollowers("anita77");
    }
}