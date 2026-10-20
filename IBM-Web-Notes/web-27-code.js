// list of recent payments
const amounts = [250, 80, 1200];

// read by index and count
console.log(amounts[0]);
console.log(amounts[1]);
console.log(amounts.length);

// change the third payment
amounts[2] = 900;
console.log(amounts);

// add to the end, remove from the end
amounts.push(60);
console.log(amounts);
amounts.pop();
console.log(amounts);

// add to the front, remove from the front
amounts.unshift(15);
amounts.shift();

// array inside an array, one row per transaction
const statement = [
  ["2026-10-01", "Groceries", 250],
  ["2026-10-02", "Airtime", 80],
  ["2026-10-03", "Rent", 1200]
];
console.log(statement[2][1]);

// loop with a for loop
let total = 0;
for (let i = 0; i < amounts.length; i++) {
  total += amounts[i];
}
console.log("Total:", total);

// loop with forEach
amounts.forEach(function (amount) {
  console.log("Payment of R" + amount);
});

// show a line on the page
document.getElementById("summary").textContent =
  amounts.length + " payments, total R" + total;