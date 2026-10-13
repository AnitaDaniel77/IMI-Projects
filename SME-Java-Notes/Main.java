import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Starts the transaction import and prints the results
public class Main {

    public static void main(String[] args) {
        System.out.println("SafePay: importing transaction data");
        System.out.println();

        // CSV path is relative to the folder we run the program from
        Path csvPath = Paths.get("data", "transactions.csv");
        CsvTransactionReader reader = new CsvTransactionReader();

        List<Transaction> transactions;
        try {
            transactions = reader.read(csvPath);
        } catch (IOException exception) {
            System.out.println("Could not read " + csvPath + ": " + exception.getMessage());
            return;
        }

        // Rows that imported
        System.out.println("Imported " + transactions.size() + " transactions:");
        for (Transaction transaction : transactions) {
            System.out.println("  " + transaction);
        }

        // Rows that failed, with their line numbers
        List<String> errors = reader.getErrors();
        System.out.println();
        System.out.println(errors.size() + " row(s) could not be imported:");
        for (String error : errors) {
            System.out.println("  " + error);
        }
    }
}