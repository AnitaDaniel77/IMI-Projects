// Declaration, no parameters
function showWelcome() {
  console.log("Welcome to the bank");
}

// Declaration, with parameters
function calculateFee(amount, rate) {
  return amount * rate;
}

// Expression, stored in a variable
const addDeposit = function (balance, deposit) {
  return balance + deposit;
};

// Arrow function, short version
const doubleIt = (amount) => amount * 2;

// Named function, easy to spot when debugging
function checkBalance(balance) {
  return balance >= 0 ? "In credit" : "Overdrawn";
}

// Calls
showWelcome();
const fee = calculateFee(500, 0.01);
console.log("Fee:", fee);
console.log("New balance:", addDeposit(1000, 250));
console.log("Doubled:", doubleIt(80));
console.log(checkBalance(-20));

// IIFE, runs straight away
(function () {
  const secret = "private to this function";
  console.log("IIFE ran:", secret);
})();

// Anonymous function passed to another function
[100, 250, 400].forEach(function (amount) {
  console.log("Fee on", amount, "is", calculateFee(amount, 0.01));
});

// Show one result on the page
document.getElementById("result").textContent = "Fee on R500: R" + fee;