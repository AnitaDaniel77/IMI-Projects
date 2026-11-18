import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    // One bank transaction
    static class Transaction {
        private final String description;
        private final double amount; // double for the demo only

        Transaction(String description, double amount) {
            this.description = description;
            this.amount = amount;
        }

        String getDescription() {
            return description;
        }

        double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        // Our data source: a list of transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("Groceries", 850.50));
        transactions.add(new Transaction("Salary", 25000));
        transactions.add(new Transaction("Airtime", 100));
        transactions.add(new Transaction("Rent", 7500));
        transactions.add(new Transaction("Fuel", 1200));

        // Loop way: names of transactions above 1000
        List<String> bigByLoop = new ArrayList<>();
        for (Transaction t : transactions) {
            if (t.getAmount() > 1000) {
                bigByLoop.add(t.getDescription());
            }
        }
        System.out.println("Loop: " + bigByLoop);

        // Stream way: same result
        List<String> bigByStream = transactions.stream()
                .filter(t -> t.getAmount() > 1000) // keep the big ones
                .map(Transaction::getDescription) // keep only the names
                .collect(Collectors.toList()); // gather into a list
        System.out.println("Stream: " + bigByStream);

        // Sort smallest to biggest, take 2, print each
        System.out.println("Two smallest:");
        transactions.stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .limit(2)
                .forEach(t -> System.out.println(t.getDescription() + " " + t.getAmount()));

        // Add all amounts into one total
        double total = transactions.stream()
                .map(Transaction::getAmount)
                .reduce(0.0, Double::sum); // start at 0, add each amount
        System.out.println("Total: " + total);
    }
}