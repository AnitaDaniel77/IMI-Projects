// What GROUP BY, HAVING, ORDER BY, joins and a subquery do, written as plain Java loops
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Db06MoreSqlInJava {

    record Sale(int saleId, String product, int amount, String region) {}
    record Customer(int customerId, String name) {}
    record Order(int orderId, int customerId, int amount) {}

    public static void main(String[] args) {
        List<Sale> sales = List.of(
            new Sale(1, "Laptop", 1000, "East"),
            new Sale(2, "Smartphone", 500, "East"),
            new Sale(3, "Laptop", 1200, "West"),
            new Sale(4, "Smartphone", 700, "West"));

        // GROUP BY Product with SUM(Amount)
        Map<String, Integer> totals = new HashMap<>();
        for (Sale s : sales) {
            int current = totals.getOrDefault(s.product(), 0);
            totals.put(s.product(), current + s.amount());
        }
        System.out.println("GROUP BY: " + totals);

        // HAVING SUM(Amount) > 1500
        System.out.println("HAVING > 1500:");
        for (String product : totals.keySet()) {
            if (totals.get(product) > 1500) {
                System.out.println("  " + product + " " + totals.get(product));
            }
        }

        // ORDER BY TotalSales DESC
        List<String> products = new ArrayList<>(totals.keySet());
        products.sort((a, b) -> totals.get(b) - totals.get(a));
        System.out.println("ORDER BY DESC: " + products);

        List<Customer> customers = List.of(
            new Customer(1, "Alice"), new Customer(2, "Bob"), new Customer(3, "Charlie"));
        List<Order> orders = List.of(new Order(101, 1, 500), new Order(102, 2, 700));

        // INNER JOIN: only customers who have a matching order
        System.out.println("INNER JOIN:");
        for (Customer c : customers) {
            for (Order o : orders) {
                if (c.customerId() == o.customerId()) {
                    System.out.println("  " + c.name() + " " + o.amount());
                }
            }
        }

        // LEFT JOIN: every customer, null when there's no order
        System.out.println("LEFT JOIN:");
        for (Customer c : customers) {
            boolean found = false;
            for (Order o : orders) {
                if (c.customerId() == o.customerId()) {
                    System.out.println("  " + c.name() + " " + o.amount());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("  " + c.name() + " null");
            }
        }

        // Subquery: names of customers with an order over 600
        List<Integer> bigSpenderIds = new ArrayList<>();
        for (Order o : orders) {
            if (o.amount() > 600) {
                bigSpenderIds.add(o.customerId()); // inner query
            }
        }
        System.out.println("Subquery:");
        for (Customer c : customers) {
            if (bigSpenderIds.contains(c.customerId())) {
                System.out.println("  " + c.name()); // outer query
            }
        }
    }
}

