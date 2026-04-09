# Java Learning Notes

## Lesson 1: Data Types (SME Session with Hilbert)

### Primitive Types
Java requires you to declare the type of every variable upfront.
Unlike JavaScript, Java won't guess the type for you.

int age = 21;           // whole numbers
double price = 12.50;   // decimal numbers
char grade = 'A';       // single character, uses single quotes
boolean isLoggedIn = false; // true or false
long population = 1400000000L; // large numbers, needs L at the end

### Wrapper Types and Autoboxing
Every primitive has a Wrapper Object version.
int -> Integer
double -> Double

Integer x = 5;  // Autoboxing - Java wraps the int into an Integer object
int y = x;      // Unboxing - Java unwraps it back to a primitive

### Common Beginner Mistakes
1. Using == instead of .equals() for Strings
2. Forgetting L on large long values e.g. 1400000000L
3. Comparing doubles with == (floating point precision issues)
4. Casting without considering data loss

### Warm-up answers
Age = int
Price of bread = double
True/False answer = boolean
Letter grade = char
Country population = long (too big for int)

## Lesson 2: Operators - Exercises

### Exercise 1 - AND &&
boolean bankIsOpen = true;
boolean hasID = false;
System.out.println(bankIsOpen && hasID); // false - customer has no ID

### Exercise 2 - OR ||
boolean hasCard = false;
boolean hasPhone = true;
System.out.println(hasCard || hasPhone); // true - phone is enough

### Exercise 3 - NOT !
boolean isSuspicious = true;
isSuspicious = !isSuspicious; // flipped to false - transaction cleared

### Exercise 4 - Modulus %
int customers = 13;
int tellers = 4;
System.out.println(customers % tellers); // 1 - one customer waiting

### Exercise 5 - String concatenation
String firstName = "Anita"; // String has capital S - it's an object not a primitive
int balance = 5000;
System.out.println("Welcome, " + firstName + "! Your balance is R" + balance);

### Exercise 6 - += building a string
String receipt = "";
receipt += "Capitec Bank\n";
receipt += "Amount: R500\n";
receipt += "Status: Approved";

### Exercise 7 - Operator precedence
int monthlyFee = 5;
int months = 12;
int bonus = 10;
System.out.println(monthlyFee * months + bonus); // 70 - BODMAS, * before +

### Key difference from JavaScript
Java requires the type declared upfront.
JavaScript: var bankIsOpen = true;
Java: boolean bankIsOpen = true;
String in Java has a capital S because it is an object, not a primitive.