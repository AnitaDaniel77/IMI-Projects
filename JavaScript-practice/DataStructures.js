// forEach — display all of Anita's transactions
const anitaTransactions = [500, 200, 1000, 350];
anitaTransactions.forEach(function(amount, index) {
    console.log(`Transaction ${index + 1}: R${amount}`);
});
// Transaction 1: R500
// Transaction 2: R200
// Transaction 3: R1000
// Transaction 4: R350

// filter — find all transactions above R400
const largeTransactions = anitaTransactions.filter(function(amount) {
    return amount > 400;
});
console.log("Large transactions:", largeTransactions); // [500, 1000]

// map — add 10% tax to each transaction
const withTax = anitaTransactions.map(function(amount) {
    return amount * 1.1;
});
console.log("Amounts with tax:", withTax); // [550, 220, 1100, 385]

// Map — store Anita and Vito's balances
let balances = new Map();
balances.set("Anita", 5500);
balances.set("Vito", 3300);
console.log(balances.get("Anita")); // 5500
console.log(balances.get("Vito"));  // 3300

// Set — unique account types
const accountTypes = new Set(["Savings", "Current", "Savings", "Credit", "Current"]);
console.log(accountTypes); // {'Savings', 'Current', 'Credit'}