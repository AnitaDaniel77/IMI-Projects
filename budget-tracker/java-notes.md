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