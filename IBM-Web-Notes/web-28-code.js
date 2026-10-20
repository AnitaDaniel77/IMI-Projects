// customers and one month of transactions
const customers = [
  { name: "Anita", email: "anita@example.com" },
  { name: "Sam", email: "sam@example.com" }
];

const transactions = [
  { ref: "TX001", name: "Groceries", amount: 250 },
  { ref: "TX002", name: "Rent", amount: 1200 },
  { ref: "TX003", name: "Airtime", amount: 80 },
  { ref: "TX004", name: "Furniture", amount: 2500 }
];

// forEach, an action for each item
function sendAlert(email) {
  console.log("Alert sent to " + email);
}
customers.forEach((customer) => sendAlert(customer.email));

// map, a new list of amounts
const amounts = transactions.map((t) => t.amount);
console.log(amounts);

// map, a new list of display lines
const lines = transactions.map((t) => `${t.name}: R${t.amount}`);
console.log(lines);

// filter, keep amounts inside a range
function inRange(list, min, max) {
  return list.filter((t) => t.amount >= min && t.amount <= max);
}
const midSized = inRange(transactions, 500, 2000);
midSized.forEach((t) => console.log(`${t.name} is R${t.amount}`));

// reduce, add everything into one total
const total = amounts.reduce((sum, amount) => sum + amount, 0);
console.log("Total:", total);

// find, first match or undefined
const match = transactions.find((t) => t.ref === "TX002");
if (match) {
  console.log(`Found ${match.ref}: ${match.name}, R${match.amount}`);
} else {
  console.log("No transaction found");
}

// show a line on the page
document.getElementById("result").textContent =
  transactions.length + " transactions, total R" + total;