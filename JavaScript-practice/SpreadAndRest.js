// Anita and Vito each have a list of favourite foods
const anitaFoods = ["pizza", "pasta", "salad"];
const vitoFoods = ["sushi", "tacos", "ramen"];

// Combine both lists into one shared list
const sharedFoods = [...anitaFoods, ...vitoFoods];
console.log(sharedFoods);
// ['pizza', 'pasta', 'salad', 'sushi', 'tacos', 'ramen']

// Copy Anita's account without affecting the original
const anitaAccount = { name: "Anita", balance: 5000 };
const backupAccount = { ...anitaAccount };

anitaAccount.balance = 4500; // Anita spends money

console.log(anitaAccount.balance);  // 4500 — updated
console.log(backupAccount.balance); // 5000 — backup unchanged

// Convert Anita's name into individual characters
const nameChars = [...anitaAccount.name];
console.log(nameChars); // ['A', 'n', 'i', 't', 'a']

// Add new items to Vito's shopping list without push()
let vitoList = ["milk", "bread"];
vitoList = [...vitoList, "eggs", "butter"];
console.log(vitoList); // ['milk', 'bread', 'eggs', 'butter']