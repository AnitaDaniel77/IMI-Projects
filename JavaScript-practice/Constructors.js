// Define a custom constructor function called Transaction
// Constructor functions start with a capital letter by convention
// It accepts two parameters: accountHolder (name) and amount (transaction value)
function Transaction(accountHolder, amount) {

    // this.accountHolder assigns the passed in name to the object's accountHolder property
    // 'this' refers to the new object being created
    this.accountHolder = accountHolder;

    // this.amount assigns the passed in amount to the object's amount property
    this.amount = amount;

    // this.date automatically captures the current date and time
    // new Date() is a built-in JavaScript constructor that creates a date object
    this.date = new Date();

    // this.describe is a method — a function stored as a property on the object
    // When called, it logs a message showing who transacted and how much
    this.describe = function() {
        console.log(this.accountHolder + " transacted R" + this.amount);
    }
}

// Create a new Transaction object for Anita using the new keyword
// "Anita" is the accountHolder and 500 is the amount
// The constructor runs and builds a new object with Anita's data
let t1 = new Transaction("Anita", 500);

// Create a new Transaction object for Vito
// "Vito" is the accountHolder and 200 is the amount
// This is a completely separate object from t1 with its own data
let t2 = new Transaction("Vito", 200);

// Call the describe method on t1 — logs Anita's transaction
t1.describe(); // Anita transacted R500

// Call the describe method on t2 — logs Vito's transaction
t2.describe(); // Vito transacted R200


// Base prototype object — all account types share these properties and methods
// Think of this as the general Capitec account template
var Account = {
    accountNumber: null,
    balance: 0,

    // checkBalance is a shared method available to all account types
    checkBalance: function() {
        console.log("Account " + this.accountNumber + " balance: R" + this.balance);
    },

    // deposit is a shared method — works the same for all account types
    deposit: function(amount) {
        this.balance += amount;
        console.log(this.accountNumber + ": R" + amount + " deposited. New balance: R" + this.balance);
    },

    // withdraw is defined on the base prototype
    // Each account type can override this with its own rules
    withdraw: function(amount) {
        this.balance -= amount;
        console.log(this.accountNumber + ": R" + amount + " withdrawn. New balance: R" + this.balance);
    }
}

// ============================================================
// SAVINGS ACCOUNT
// Inherits from Account but overrides withdraw()
// Rule: balance cannot go below R500 (minimum balance)
// ============================================================

// Create SavingsAccount using Account as its prototype
var SavingsAccount = Object.create(Account);

// Override the withdraw method on SavingsAccount only
// This does not affect the base Account prototype
SavingsAccount.withdraw = function(amount) {

    // Check if the withdrawal would drop the balance below R500
    if (this.balance - amount < 500) {
        console.log("Withdrawal denied. Savings accounts must maintain a minimum balance of R500.");
    } else {
        // If the rule is satisfied, proceed with the withdrawal
        this.balance -= amount;
        console.log(this.accountNumber + ": R" + amount + " withdrawn. New balance: R" + this.balance);
    }
}

// ============================================================
// CURRENT ACCOUNT
// Inherits from Account but overrides withdraw()
// Rule: allows overdraft up to R1000
// ============================================================

// Create CurrentAccount using Account as its prototype
var CurrentAccount = Object.create(Account);

// Override the withdraw method on CurrentAccount only
CurrentAccount.withdraw = function(amount) {

    // Check if the withdrawal would exceed the R1000 overdraft limit
    if (this.balance - amount < -1000) {
        console.log("Withdrawal denied. Overdraft limit of R1000 exceeded.");
    } else {
        // If within overdraft limit, allow the withdrawal
        this.balance -= amount;
        console.log(this.accountNumber + ": R" + amount + " withdrawn. New balance: R" + this.balance);
    }
}

// ============================================================
// CREATE ANITA'S SAVINGS ACCOUNT
// ============================================================

// Object.create(SavingsAccount) means Anita's account inherits
// from SavingsAccount which in turn inherits from Account
var anitaAccount = Object.create(SavingsAccount);

// Set Anita's account specific details
anitaAccount.accountNumber = "SAV-001";
anitaAccount.balance = 5000;

// ============================================================
// CREATE VITO'S CURRENT ACCOUNT
// ============================================================

var vitoAccount = Object.create(CurrentAccount);

// Set Vito's account specific details
vitoAccount.accountNumber = "CUR-001";
vitoAccount.balance = 1000;

// ============================================================
// TEST THE ACCOUNTS
// ============================================================

// Anita's savings account tests
console.log("--- Anita's Savings Account ---");
anitaAccount.checkBalance();         // R5000
anitaAccount.deposit(500);           // deposits R500 — balance becomes R5500
anitaAccount.withdraw(4000);         // allowed — balance stays above R500
anitaAccount.withdraw(1500);         // denied — would drop below R500 minimum

// Vito's current account tests
console.log("--- Vito's Current Account ---");
vitoAccount.checkBalance();          // R1000
vitoAccount.withdraw(1500);          // allowed — goes into overdraft but within R1000 limit
vitoAccount.withdraw(600);           // denied — would exceed R1000 overdraft limit
vitoAccount.deposit(1000);           // deposits R1000 to recover from overdraft
vitoAccount.checkBalance();          // shows updated balance