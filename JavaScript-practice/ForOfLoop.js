// ============================================================
// FOR OF LOOP AND OBJECT METHODS
// Real Life Example — Capitec Bank Account
// ============================================================


// ============================================================
// THE PROBLEM — objects are not iterable
// You cannot loop directly over an object with for of
// ============================================================

const car = {
    speed: 100,
    color: "blue"
}

// This will throw: Uncaught TypeError: car is not iterable
// for (prop of car) { console.log(prop) }
// Objects need to be converted to arrays first before looping


// ============================================================
// FOR OF WORKS ON ARRAYS
// Arrays are iterable so for of works perfectly on them
// ============================================================

const colors = ['red', 'orange', 'yellow']

// color is a variable that takes each value in the array one by one
// on the first loop color = 'red', second = 'orange', third = 'yellow'
for (var color of colors) {
    console.log(color);
}
// Output:
// red
// orange
// yellow


// ============================================================
// THREE BUILT-IN METHODS TO MAKE OBJECTS LOOP-FRIENDLY
// These convert an object into an array so for of can work
// ============================================================

// Object.keys() — gives you an array of the property NAMES only
const car2 = { speed: 200, color: "red" }
console.log(Object.keys(car2));
// Output: ['speed', 'color']
// Only the names — no values

// Object.values() — gives you an array of the property VALUES only
const car3 = { speed: 300, color: "yellow" }
console.log(Object.values(car3));
// Output: [300, 'yellow']
// Only the values — no names

// Object.entries() — gives you BOTH names and values as pairs
const car4 = { speed: 400, color: 'magenta' }
console.log(Object.entries(car4));
// Output: [ ['speed', 400], ['color', 'magenta'] ]
// Each item is an array with two members: [name, value]


// ============================================================
// LOOPING OVER AN OBJECT USING FOR OF AND Object.keys()
// ============================================================

var clothingItem = {
    price: 50,
    color: 'beige',
    material: 'cotton',
    season: 'autumn'
}

// Object.keys(clothingItem) converts the object into ['price', 'color', 'material', 'season']
// for of then loops over that array one key at a time
// clothingItem[key] uses bracket notation to get the value for each key
for (const key of Object.keys(clothingItem)) {
    console.log(key, ":", clothingItem[key]);
}
// Output:
// price : 50
// color : beige
// material : cotton
// season : autumn


// ============================================================
// FOR IN VS FOR OF
// for in loops over KEYS of an object directly
// for of loops over VALUES of an array
// ============================================================

const anotherCar = { speed: 100, color: "blue" };

// for in — gives you the property names (keys)
for (let key in anotherCar) {
    console.log(key); // speed, color
}

// for of with Object.keys — same result but using for of style
for (const key of Object.keys(anotherCar)) {
    console.log(key); // speed, color
}


// ============================================================
// DYNAMIC BRACKET NOTATION
// The key used to access an object property can be a variable
// This means you can decide which property to access at runtime
// ============================================================

function testBracketsDynamicAccess() {

    // dynamicKey will hold either "speed" or "color"
    // the value is decided randomly each time the function runs
    var dynamicKey;

    // Math.random() returns a number between 0 and 1
    // if it is above 0.5 we access speed, otherwise we access color
    if (Math.random() > 0.5) {
        dynamicKey = "speed";
    } else {
        dynamicKey = "color";
    }

    var drone = {
        speed: 15,
        color: "orange"
    }

    // drone[dynamicKey] changes based on what dynamicKey holds
    // if dynamicKey is "speed" this becomes drone["speed"] which is 15
    // if dynamicKey is "color" this becomes drone["color"] which is "orange"
    console.log(drone[dynamicKey]); // either 15 or "orange" — random each time
}

// run the function a few times to see the random output change
testBracketsDynamicAccess();
testBracketsDynamicAccess();
testBracketsDynamicAccess();


// ============================================================
// REAL LIFE EXAMPLE — CAPITEC BANK ACCOUNT
// Looping over Anita and Vito's account details
// ============================================================

// Anita's account object — stores all her account information
var anitaAccount = {
    accountHolder: "Anita",    // name of the account holder
    balance: 5000,             // current balance in rands
    accountType: "Current",    // type of account
    branch: "Brakpan"          // branch where account was opened
}

// Vito's account object — same structure, different values
var vitoAccount = {
    accountHolder: "Vito",
    balance: 3000,
    accountType: "Savings",
    branch: "Johannesburg"
}

// Display all of Anita's account details using for of and Object.keys()
// Object.keys(anitaAccount) gives us ['accountHolder', 'balance', 'accountType', 'branch']
// for of loops through each key one by one
// anitaAccount[key] gets the value for each key using bracket notation
console.log("--- Anita's Account Details ---");
for (const key of Object.keys(anitaAccount)) {
    console.log(key + ": " + anitaAccount[key]);
}
// Output:
// accountHolder: Anita
// balance: 5000
// accountType: Current
// branch: Brakpan

// Display all of Vito's account details using Object.entries()
// Object.entries() gives us both the key and value together as a pair
// we use destructuring [key, value] to unpack each pair directly
console.log("--- Vito's Account Details ---");
for (const [key, value] of Object.entries(vitoAccount)) {
    console.log(key + ": " + value);
}
// Output:
// accountHolder: Vito
// balance: 3000
// accountType: Savings
// branch: Johannesburg

// Display only the values of Anita's account using Object.values()
// useful when you only care about the values and not the property names
console.log("--- Anita's Account Values Only ---");
for (const value of Object.values(anitaAccount)) {
    console.log(value);
}
// Output:
// Anita
// 5000
// Current
// Brakpan