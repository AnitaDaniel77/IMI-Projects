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