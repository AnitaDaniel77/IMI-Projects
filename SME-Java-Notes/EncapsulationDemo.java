public class EncapsulationDemo {
    public static void main(String[] args) {

        // THE PROBLEM WITH PUBLIC FIELDS
        // if fields are public, ANY code can write any value.
        // nothing stops a negative balance or an empty name. That is hard to protect and hard to change later.

        OpenAccount risky = new OpenAccount();
        risky.owner = "";
        risky.balance = -500; // nonsense, but the compiler allows it
        System.out.println("Public fields: owner='" + risky.owner + "', balance=" + risky.balance);

        // ENCAPSULATION
        // hide the fields with 'private'. Expose a controlled door: public getters and setters.
        //
        //   outside code
        //        |
        //        v
        //   getBalance() / deposit() / withdraw()
        //        |
        //        v
        //   private balance   <--- only methods inside the class touch this

        BankAccount account = new BankAccount("Ada", 100.0);
        System.out.println(account.summary()); // Ada: 100.0

        // GETTERS AND SETTERS
        // getter — read the value safely.
        // setter / operations — change the value with rules.

        System.out.println("Owner: " + account.getOwner());
        System.out.println("Balance: " + account.getBalance());

        account.deposit(50);
        System.out.println("After deposit 50: " + account.summary()); // Ada: 150.0

        account.withdraw(20);
        System.out.println("After withdraw 20: " + account.summary()); // Ada: 130.0

        // VALIDATION INSIDE THE DOOR
        account.setOwner(""); // Rejected: owner must not be empty.
        account.deposit(-10); // Rejected: deposit must be positive.
        account.withdraw(10000); // Rejected: not enough funds.
    }
}

// BEFORE: public fields, no protection at all.
class OpenAccount {
    String owner;
    double balance;
}

// AFTER: private state + public operations.
class BankAccount {

    private String owner;
    private double balance;

    BankAccount(String owner, double openingBalance) {
        this.owner = owner;
        // guard opening balance too
        this.balance = openingBalance < 0 ? 0 : openingBalance;
    }

    // ----- getters (read) -----

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    // ----- setters / operations (write with rules) -----

    public void setOwner(String owner) {
        if (owner == null || owner.isBlank()) {
            System.out.println("Rejected: owner must not be empty.");
            return;
        }
        this.owner = owner;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected: deposit must be positive.");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Rejected: withdraw must be positive.");
            return;
        }
        if (amount > balance) {
            System.out.println("Rejected: not enough funds.");
            return;
        }
        balance -= amount;
    }

    public String summary() {
        return owner + ": " + balance;
    }
}