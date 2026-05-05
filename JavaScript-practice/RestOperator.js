// Anita has a list of monthly expenses
// She wants to separate her top 3 priorities from the rest
const anitaExpenses = [
    "Rent",
    "Groceries",
    "Transport",
    "Gym",
    "Eating out",
    "Subscriptions"
];

// First three are priorities, rest are optional
const [priority1, priority2, priority3, ...optional] = anitaExpenses;

console.log("Priority expenses:");
console.log(priority1); // Rent
console.log(priority2); // Groceries
console.log(priority3); // Transport

console.log("Optional expenses:", optional);
// ['Gym', 'Eating out', 'Subscriptions']

// Vito uses rest in a function to calculate total spend
// discount is fixed, ...prices collects all item prices
function calculateTotal(discount, ...prices) {
    const total = prices.reduce(function(sum, price) {
        return sum + price;
    }, 0);
    return total - discount;
}

const vitoTotal = calculateTotal(50, 200, 350, 100, 75);
console.log("Vito's total after discount: R" + vitoTotal); // R675