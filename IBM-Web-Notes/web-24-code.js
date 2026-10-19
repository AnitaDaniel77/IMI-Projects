// const for values that shouldn't change
const bankName = "Capitec";

// let for values that will change
let balance = 1000;
balance = 1500;

// declared but no value yet
let overdraftLimit;

// var leaks out of the block, let doesn't
if (true) {
  var oldStyle = "visible outside";
  let newStyle = "stays inside";
}
console.log(oldStyle);
console.log(typeof newStyle); // undefined, it's out of scope

// const can't be reassigned
try {
  bankName = "Other Bank";
} catch (error) {
  console.log("Error:", error.message);
}

// primitive types
const holder = "Anita";
const isActive = true;
const linkedCard = null;

// composite types
const lastAmounts = [250, 80, 1200];
const customer = { name: holder, id: "C101", balance: balance };

// const array can still grow
lastAmounts.push(60);

// check the types
console.log(typeof holder);          // string
console.log(typeof balance);         // number
console.log(typeof isActive);        // boolean
console.log(typeof overdraftLimit);  // undefined
console.log(linkedCard);             // null
console.log(Array.isArray(lastAmounts)); // true
console.log(customer);

// show a line on the page
document.getElementById("summary").textContent =
  bankName + ": " + customer.name + " has R" + customer.balance;