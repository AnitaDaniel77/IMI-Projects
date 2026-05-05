// ============================================================
// JSON — JavaScript Object Notation
// JSONMethods.js
// Converting between JSON strings and JavaScript objects
// ============================================================


// ============================================================
// WHAT IS JSON?
// JSON is just a string that looks like a JavaScript object
// It is used to send data between servers and web applications
// All keys must be in double quotes
// No functions, comments or undefined values allowed
// ============================================================


// ============================================================
// PART 1 — JSON.parse()
// Converts a JSON STRING into a JavaScript OBJECT
// Use this when you receive data from a server
// ============================================================

// This is a JSON string — notice the outer single quotes make it a string
// The inner double quotes are required by JSON formatting rules
const JSONstr = '{"greeting": "hello"}';

// JSON.parse() reads the string and converts it into a real JavaScript object
// Once parsed you can access and update its properties like any normal object
const aPlainObj = JSON.parse(JSONstr);

console.log(aPlainObj);           // {greeting: 'hello'}
console.log(aPlainObj.greeting);  // hello

// Now that it is a JavaScript object we can update its properties
// This would not be possible on the raw JSON string
aPlainObj.greeting = "hi";
console.log(aPlainObj.greeting);  // hi — value has been updated


// ============================================================
// PART 2 — JSON.stringify()
// Converts a JavaScript OBJECT into a JSON STRING
// Use this when you want to send data to a server
// ============================================================

// Start with a regular JavaScript object
const data = {
    name: "Anita",
    age: 28,
    active: true
};

// JSON.stringify() converts the object into a JSON formatted string
// All keys and string values are wrapped in double quotes automatically
const jsonData = JSON.stringify(data);
console.log(jsonData);
// '{"name":"Anita","age":28,"active":true}'


// ============================================================
// PART 3 — FUNCTIONS ARE EXCLUDED WHEN STRINGIFYING
// JavaScript objects can hold functions but JSON cannot
// When you stringify an object with a function it is silently removed
// No error is thrown — the function just disappears from the output
// ============================================================

// Object with a method (function as a property)
const user = {
    name: "Vito",
    greet: function() {
        console.log("Hello!");
    }
};

// Stringify the object — the greet function will be silently removed
const jsonUser = JSON.stringify(user);
console.log(jsonUser);
// '{"name":"Vito"}' — greet is gone because functions are not valid JSON


// ============================================================
// PART 4 — FULL ROUND TRIP
// This is the standard workflow when working with APIs
// Step 1: Receive JSON string from server
// Step 2: Parse it into a JavaScript object
// Step 3: Work with the data
// Step 4: Stringify it and send it back to the server
// ============================================================

// Step 1 — Start with a JavaScript object representing Anita's account
const anitaAccount = {
    accountHolder: "Anita",
    balance: 5000,
    accountType: "Current"
};

// Step 2 — Stringify the object to send to the server
// The object becomes a JSON string ready for transmission
const jsonString = JSON.stringify(anitaAccount);
console.log("Stringified:");
console.log(jsonString);
// '{"accountHolder":"Anita","balance":5000,"accountType":"Current"}'

// Step 3 — Parse the JSON string back into a JavaScript object
// Simulates receiving data from a server and converting it for use
const parsedAccount = JSON.parse(jsonString);
console.log("Parsed:");
console.log(parsedAccount.accountHolder); // Anita
console.log(parsedAccount.balance);       // 5000

// Step 4 — Update the balance after a transaction
// This is only possible because it is now a JavaScript object
parsedAccount.balance = 4500;
console.log("Updated balance: R" + parsedAccount.balance); // R4500

// Step 5 — Stringify the updated object to send back to the server
const updatedJson = JSON.stringify(parsedAccount);
console.log("Updated JSON sent back to server:");
console.log(updatedJson);
// '{"accountHolder":"Anita","balance":4500,"accountType":"Current"}'


// ============================================================
// PART 5 — REAL LIFE EXAMPLE
// Currency exchange data received from a third party server
// Parsed into an object, used for calculations, sent back as JSON
// ============================================================

// Data arrives from the server as a JSON string
// This is exactly how real API responses look
const currencyData = '{"USD": {"rate": 18.5}, "GBP": {"rate": 23.1}, "EUR": {"rate": 20.4}}';

// Parse the JSON string into a JavaScript object so we can work with it
const currencyInfo = JSON.parse(currencyData);

// Access specific currency rates using dot notation
console.log("USD rate: R" + currencyInfo.USD.rate); // USD rate: R18.5
console.log("GBP rate: R" + currencyInfo.GBP.rate); // GBP rate: R23.1
console.log("EUR rate: R" + currencyInfo.EUR.rate);  // EUR rate: R20.4

// Anita wants to convert her R5000 balance to USD
const anitaBalance = 5000;
const usdAmount = anitaBalance / currencyInfo.USD.rate;
console.log(`Anita's R${anitaBalance} in USD: $${usdAmount.toFixed(2)}`);
// Anita's R5000 in USD: $270.27

// Vito wants to convert his R3000 to GBP
const vitoBalance = 3000;
const gbpAmount = vitoBalance / currencyInfo.GBP.rate;
console.log(`Vito's R${vitoBalance} in GBP: £${gbpAmount.toFixed(2)}`);
// Vito's R3000 in GBP: £129.87

// Send the currency data back to the server as a JSON string
const updatedCurrencyJson = JSON.stringify(currencyInfo);
console.log("Sending back to server:");
console.log(updatedCurrencyJson);
// '{"USD":{"rate":18.5},"GBP":{"rate":23.1},"EUR":{"rate":20.4}}'


// ============================================================
// KEY LIMITATIONS TO REMEMBER
// ============================================================

// 1. Comments are NOT allowed in JSON
//    This would be invalid JSON:
//    '{"name": "Anita" /* account holder */}'

// 2. Functions are silently removed when stringifying
//    No error is thrown — they just disappear

// 3. BigInt numbers throw an error when stringified
//    For example: JSON.stringify(123n) throws TypeError

// 4. undefined values are also removed when stringifying
//    const obj = { name: "Anita", score: undefined }
//    JSON.stringify(obj) gives '{"name":"Anita"}' — score is gone