// ============================================================
// REAL LIFE EXAMPLE — CAPITEC BANK ACCOUNT
// Default Parameters in JavaScript
// ============================================================

// BankAccount class with default parameters
// Default parameters mean the class works even if no arguments are passed
// Each parameter has a fallback value that kicks in when nothing is provided
class BankAccount {
    constructor(
        accountHolder = "Anonymous", // if no name is given, use "Anonymous"
        balance = 0,                 // if no balance is given, start at R0
        accountType = "Savings"      // if no account type is given, default to Savings
    ) {
        // Assign each parameter to the object's own properties
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
    }

    // deposit adds money to the balance
    // amount defaults to 0 so calling deposit() without an argument won't crash
    deposit(amount = 0) {
        this.balance += amount;
        console.log(
            this.accountHolder + " deposited R" + amount +
            ". New balance: R" + this.balance
        );
    }

    // withdraw removes money from the balance
    // amount defaults to 0 so calling withdraw() without an argument won't crash
    withdraw(amount = 0) {

        // Check if there is enough money before allowing the withdrawal
        if (amount > this.balance) {
            console.log(
                "Withdrawal denied. " + this.accountHolder +
                " only has R" + this.balance + " available."
            );
        } else {
            this.balance -= amount;
            console.log(
                this.accountHolder + " withdrew R" + amount +
                ". Remaining balance: R" + this.balance
            );
        }
    }

    // describe prints a summary of the account details
    describe() {
        console.log(
            this.accountHolder + " has a " + this.accountType +
            " account with a balance of R" + this.balance
        );
    }
}

// ============================================================
// TEST 1 — NO ARGUMENTS PASSED
// All three default values are used
// ============================================================

var testAccount = new BankAccount();
testAccount.describe();
// Anonymous has a Savings account with a balance of R0

// ============================================================
// TEST 2 — ANITA'S ACCOUNT
// All three custom values are passed — defaults are overridden
// ============================================================

// Anita opens a Current account with R5000
var anita = new BankAccount("Anita", 5000, "Current");
anita.describe();
// Anita has a Current account with a balance of R5000

// Anita deposits R1000
anita.deposit(1000);
// Anita deposited R1000. New balance: R6000

// Anita withdraws R500
anita.withdraw(500);
// Anita withdrew R500. Remaining balance: R5500

// Anita tries to withdraw more than she has
anita.withdraw(10000);
// Withdrawal denied. Anita only has R5500 available.

// ============================================================
// TEST 3 — VITO'S ACCOUNT
// Only name and balance are passed
// accountType defaults to "Savings" because it was not provided
// ============================================================

var vito = new BankAccount("Vito", 3000);
vito.describe();
// Vito has a Savings account with a balance of R3000

// Vito deposits R500
vito.deposit(500);
// Vito deposited R500. New balance: R3500

// Vito withdraws R200
vito.withdraw(200);
// Vito withdrew R200. Remaining balance: R3300