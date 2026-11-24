// Shows how a transaction works: a transfer either fully happens or is fully undone
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Db03TransactionDemo {

    // Pretend database: account number -> balance
    static Map<String, BigDecimal> accounts = new HashMap<>();

    // Moves money between accounts as one all-or-nothing step
    static boolean transfer(String from, String to, BigDecimal amount) {
        // Keep a copy so we can roll back
        Map<String, BigDecimal> backup = new HashMap<>(accounts);

        try {
            BigDecimal fromBalance = accounts.get(from);
            if (fromBalance == null || !accounts.containsKey(to)) {
                throw new IllegalArgumentException("Account not found");
            }
            if (fromBalance.compareTo(amount) < 0) {
                throw new IllegalArgumentException("Not enough funds");
            }

            accounts.put(from, fromBalance.subtract(amount)); // step 1: take money out
            accounts.put(to, accounts.get(to).add(amount));   // step 2: put money in

            System.out.println("COMMIT: moved R" + amount + " from " + from + " to " + to);
            return true;

        } catch (IllegalArgumentException e) {
            accounts.clear();
            accounts.putAll(backup); // rollback: restore the copy
            System.out.println("ROLLBACK: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        accounts.put("ACC-1", new BigDecimal("500.00"));
        accounts.put("ACC-2", new BigDecimal("100.00"));

        transfer("ACC-1", "ACC-2", new BigDecimal("200.00")); // works
        transfer("ACC-1", "ACC-2", new BigDecimal("900.00")); // not enough funds
        transfer("ACC-1", "ACC-9", new BigDecimal("50.00"));  // account missing

        System.out.println("Final balances: " + accounts);
    }
}