// Define a class called BankAccount
// A class is a blueprint for creating objects with the same structure
class BankAccount {

    // The constructor runs automatically when a new BankAccount object is created
    // It accepts two parameters: accountHolder (name) and balance (starting amount)
    constructor(accountHolder, balance) {
        // this.accountHolder refers to the property of the object being created
        // We assign the passed in accountHolder value to the object's accountHolder property
        this.accountHolder = accountHolder;

        // We assign the passed in balance value to the object's balance property
        this.balance = balance;
    }

    // deposit() is a method — a function that belongs to the BankAccount class
    // It accepts one parameter: amount (how much to deposit)
    deposit(amount) {
        // this.balance refers to the balance of the current object
        // += adds the deposit amount to the existing balance
        this.balance += amount;

        // Log a message to confirm the deposit was made
        console.log(this.accountHolder + " deposited R" + amount);
    }

    // checkBalance() is a method that displays the current balance
    checkBalance() {
        // this.accountHolder gets the name of the current object
        // this.balance gets the current balance of the current object
        console.log(this.accountHolder + "'s balance: R" + this.balance);
    }
}

// Create a new BankAccount object for Anita using the class blueprint
// "Anita" is the accountHolder, 5000 is the starting balance
var anita = new BankAccount("Anita", 5000);

// Create a new BankAccount object for Vito using the same class blueprint
// "Vito" is the accountHolder, 3000 is the starting balance
var vito = new BankAccount("Vito", 3000);

// Call the deposit method on Anita's account — adds R500 to her balance
anita.deposit(500);

// Call checkBalance on Anita's account — should show R5500
anita.checkBalance(); // Anita's balance: R5500

// Call checkBalance on Vito's account — should show R3000 (no deposit made)
vito.checkBalance(); // Vito's balance: R3000


// Define a base class called Person
// This is the parent class (superclass) that other classes can inherit from
class Person {

    // greet() is a method available to all Person objects and subclasses
    greet() {
        console.log("Hello!");
    }
}

// Anita class extends Person — this means Anita inherits everything from Person
// extends sets up the inheritance relationship
class Anita extends Person {

    // greet() is overridden here — Anita has her own version of the method
    greet() {
        // super.greet() calls the parent class (Person) greet() method first
        // This prints "Hello!" before Anita's custom message
        super.greet();

        // Then adds Anita's own message after the parent method runs
        console.log("I am Anita, Java Trainee at Capitec.");
    }
}

// Vito class also extends Person — inherits from the same parent class
class Vito extends Person {

    // greet() is completely overridden — Vito does not call super.greet()
    // He replaces the parent method entirely with his own
    greet() {
        console.log("Hey, I am Vito!");
    }
}

// Create a new instance of the Anita class using the new keyword
// anita is now an object built from the Anita blueprint
var anita = new Anita();

// Create a new instance of the Vito class
// vito is now an object built from the Vito blueprint
var vito = new Vito();

// Call greet() on anita — runs Person's greet() first then Anita's message
anita.greet();
// Output:
// Hello!
// I am Anita, Java Trainee at Capitec.

// Call greet() on vito — runs only Vito's version, parent method is not called
vito.greet();
// Output:
// Hey, I am Vito!