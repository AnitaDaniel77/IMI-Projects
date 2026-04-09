# JavaScript Learning Notes

## Lesson 1: Syntax, Variables & the Console

### What I learned

#### Printing to the console
console.log() is how you print output in JavaScript.
You can style console output using %c:
console.log("%cHello, World", "color: blue; font-size: 40px")

#### Variables
Variables store values you want to use later.
Like a labelled box — you put something in and refer to it by name.

var person = "John"
var greeting = "Hello"
console.log(greeting, person) // prints: Hello John

Variables can be reassigned:
greeting = "hi"
person = "James"
console.log(greeting, person) // prints: hi James

### Mistakes I made and what they taught me

1. console.log("Hello, person)
   Missing closing quote — JavaScript couldn't find the end of the string.
   Error: Uncaught SyntaxError: Invalid or unexpected token

2. cosole.log(greeting, person)
   Typo — cosole instead of console.
   Error: Uncaught ReferenceError: cosole is not defined
   Lesson: JavaScript is exact. One wrong letter breaks everything.

### Key takeaways
- var declares a variable
- Strings need matching quotes — open and close
- console.log() can take multiple values separated by commas
- Typos cause ReferenceErrors — always check spelling first

## Lesson 2: Variables Practice Exercise

### What I practiced
- Declaring variables with var
- Logging multiple values with console.log()
- Reassigning variable values
- Combining strings and variables in console.log()

### Mistake I made and what it taught me

1. console.log("My pet dog's name is": petDog)
   Used a colon instead of a comma.
   Fix: console.log("My pet dog's name is:", petDog)

2. catSound is not defined
   Tried to use a variable before declaring it.
   Variables reset when the console clears — always declare first.
   Fix: var catSound = "purr" then use it.

### Key takeaways
- Separate values in console.log() with commas, not colons
- Always declare a variable before using it
- var can be reassigned at any time — catSound changed from "purr" to "meow"

### Full console session
var petDog = "Rex"
var petCat = "Pepper"
console.log(petDog) // Rex
console.log(petCat) // Pepper
console.log("My pet dog's name is:", petDog) // My pet dog's name is: Rex
console.log("My pet cat's name is:", petCat) // My pet cat's name is: Pepper
var catSound = "purr"
var dogSound = "woof"
console.log(petDog, "says", dogSound) // Rex says woof
console.log(petCat, "says", catSound) // Pepper says purr
catSound = "meow"
console.log(petCat, "now says", catSound) // Pepper now says meow


## Lesson 3: Strings

### What I learned
Strings are text values wrapped in quotes — single or double.

Examples:
'hello there!'
'Hello there!123'
"It's a lovely day"

### Mistake I made and what it taught me

1. 'It's a lovely day'
   The apostrophe in "It's" closed the string too early.
   Error: Uncaught SyntaxError: Unexpected identifier 's'
   Fix: Use double quotes when your string contains an apostrophe.
   "It's a lovely day"

2. 'hello  (pressing Enter inside a string)
   Strings cannot span multiple lines with single or double quotes.
   Error: Uncaught SyntaxError: Invalid or unexpected token

### Key takeaway
Match your quotes to what's inside the string.
If the text has an apostrophe, use double quotes on the outside.

## Lesson 3: Operators - Exercises

### Exercise 1 - AND &&
Both conditions must be true.
Capitec teller example - bank must be open AND customer must have ID.
var bankIsOpen = true;
var hasID = true;
console.log(bankIsOpen && hasID); // true
// one false makes the whole thing false

### Exercise 2 - OR ||
At least one condition must be true.
ATM example - customer needs card OR phone to get cash.
var hasCard = false;
var hasPhone = true;
console.log(hasCard || hasPhone); // true
// only false when both sides are false

### Exercise 3 - NOT !
Flips the value from true to false or false to true.
var isSuspicious = true;
isSuspicious = !isSuspicious; // now false - transaction cleared

### Exercise 4 - Modulus %
Returns the remainder after division.
var customers = 13;
var tellers = 4;
console.log(customers % tellers); // 1 - one customer waiting

### Exercise 5 - String concatenation
+ joins strings and variables together.
var firstName = "Anita";
var balance = 5000;
console.log("Welcome, " + firstName + "! Your balance is R" + balance);
// Welcome, Anita! Your balance is R5000

### Exercise 6 - += building a string
Builds a string piece by piece.
\n means new line - like pressing Enter.
var receipt = "";
receipt += "Capitec Bank\n";
receipt += "Amount: R500\n";
receipt += "Status: Approved";

### Exercise 7 - Operator precedence
Works like BODMAS - multiplication before addition.
5 * 12 + 10 = 70 (not 110)

## Lesson 3: Operator Exercises - Coursera Tasks

### Task 1 - AND operator
var score = 8;
console.log("Mid-level skills:", score > 0 && score < 10); // true

### Task 2 - OR operator
var timeRemaining = 0;
var energy = 10;
console.log("Game over:", timeRemaining == 0 || energy == 0); // true

### Task 3 - Modulus to check even numbers
var num1 = 2;
var num2 = 5;
var test1 = num1 % 2;
var test2 = num2 % 2;
var result1 = test1 == 0;
var result2 = test2 == 0;
console.log("Is", num1, "an even number?", result1); // true
console.log("Is", num2, "an even number?", result2); // false

### Task 4 - Addition
console.log(5 + 10); // 15

### Task 5 - Concatenation
var now = "Now in ";
var three = 3;
var d = "D!";
console.log(now + three + d); // Now in 3D!

### Task 6 - += accumulating values
var counter = 0;
counter += 5;
counter += 3;
console.log(counter); // 8

### Mistake I made
/n counter = += 5
Wrong on two counts - /n is for strings only, and += doesn't need = before it.
Fix: counter += 5