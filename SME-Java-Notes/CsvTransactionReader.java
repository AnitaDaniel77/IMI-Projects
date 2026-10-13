import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

// Reads the transaction CSV and turns each good row into a Transaction.
// Splits on commas only, so quotes and commas inside a field aren't handled.
public class CsvTransactionReader {

    private static final String EXPECTED_HEADER =
            "transaction_id,customer_id,amount,currency,location,timestamp";
    private static final int EXPECTED_COLUMN_COUNT = 6;

    // Column positions, so the code has no mystery numbers
    private static final int TRANSACTION_ID_COLUMN = 0;
    private static final int CUSTOMER_ID_COLUMN = 1;
    private static final int AMOUNT_COLUMN = 2;
    private static final int CURRENCY_COLUMN = 3;
    private static final int LOCATION_COLUMN = 4;
    private static final int TIMESTAMP_COLUMN = 5;

    // Problems found while reading, so bad rows don't stop the import
    private final List<String> errors = new ArrayList<>();

    // Returns the rows that parsed; problems go in the errors list
    public List<Transaction> read(Path csvFile) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        errors.clear();

        // try-with-resources closes the file when the block ends
        try (BufferedReader reader = Files.newBufferedReader(csvFile)) {
            String headerLine = reader.readLine();
            int lineNumber = 1;

            if (headerLine == null) {
                errors.add("The CSV file is empty.");
                return transactions;
            }

            // Only read the data rows if the header is what we expect
            if (!EXPECTED_HEADER.equals(headerLine.trim())) {
                errors.add("Line " + lineNumber + ": unexpected header \"" + headerLine + "\".");
                return transactions;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                Transaction transaction = parseRow(line, lineNumber);
                if (transaction != null) {
                    transactions.add(transaction);
                }
            }
        }

        return transactions;
    }

    // Problems found by the last read
    public List<String> getErrors() {
        return errors;
    }

    // Turns one line into a Transaction, or null if a value can't be converted
    private Transaction parseRow(String line, int lineNumber) {
        String[] fields = line.split(",", -1);

        if (fields.length != EXPECTED_COLUMN_COUNT) {
            errors.add("Line " + lineNumber + ": expected " + EXPECTED_COLUMN_COUNT
                    + " columns but found " + fields.length + ".");
            return null;
        }

        String transactionId = fields[TRANSACTION_ID_COLUMN].trim();
        String customerId = fields[CUSTOMER_ID_COLUMN].trim();
        String amountText = fields[AMOUNT_COLUMN].trim();
        String currency = fields[CURRENCY_COLUMN].trim();
        String location = fields[LOCATION_COLUMN].trim();
        String timestampText = fields[TIMESTAMP_COLUMN].trim();

        // A negative amount like -50.00 is a valid decimal; only non-numeric text fails here
        BigDecimal amount;
        try {
            amount = new BigDecimal(amountText);
        } catch (NumberFormatException exception) {
            errors.add("Line " + lineNumber + ": could not parse amount \""
                    + amountText + "\" as a decimal number.");
            return null;
        }

        LocalDateTime timestamp;
        try {
            timestamp = LocalDateTime.parse(timestampText);
        } catch (DateTimeParseException exception) {
            errors.add("Line " + lineNumber + ": could not parse timestamp \""
                    + timestampText + "\" as a date and time.");
            return null;
        }

        return new Transaction(transactionId, customerId, amount, currency, location, timestamp);
    }
}