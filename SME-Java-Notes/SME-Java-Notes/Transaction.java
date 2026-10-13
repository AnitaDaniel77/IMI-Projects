import java.math.BigDecimal;
import java.time.LocalDateTime;

// One payment read from the CSV, with real Java types
public class Transaction {

    // Final fields: a payment can't change after it's created
    private final String transactionId;
    private final String customerId;
    private final BigDecimal amount;
    private final String currency;
    private final String location;
    private final LocalDateTime timestamp;

    // Sets all six values in one go
    public Transaction(String transactionId, String customerId, BigDecimal amount,
                       String currency, String location, LocalDateTime timestamp) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
        this.currency = currency;
        this.location = location;
        this.timestamp = timestamp;
    }

    public String getTransactionId() { return transactionId; }
    public String getCustomerId() { return customerId; }
    public BigDecimal getAmount() { return amount; }
    public String getCurrency() { return currency; }
    public String getLocation() { return location; }
    public LocalDateTime getTimestamp() { return timestamp; }

    // One-line summary for printing
    @Override
    public String toString() {
        return transactionId + " | " + customerId + " | " + currency + " " + amount
                + " | " + location + " | " + timestamp;
    }
}