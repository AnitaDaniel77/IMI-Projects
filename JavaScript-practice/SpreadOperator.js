// Copying an array without affecting the original
const original = [1, 2, 3];
const copy = [...original];
copy.push(4);

console.log(original); // [1, 2, 3] — unchanged
console.log(copy);     // [1, 2, 3, 4]

// Combining two arrays into one
const anitaFavourites = ["pizza", "pasta"];
const vitoFavourites = ["sushi", "tacos"];
const combined = [...anitaFavourites, ...vitoFavourites];
console.log(combined); // ['pizza', 'pasta', 'sushi', 'tacos']

// Copying an object
const anitaAccount = { name: "Anita", balance: 5000 };
const accountCopy = { ...anitaAccount };
console.log(accountCopy); // { name: 'Anita', balance: 5000 }

// Combining two objects — if keys clash, the last one wins
const basicInfo = { name: "Vito", age: 28 };
const accountInfo = { balance: 3000, accountType: "Savings" };
const vitoProfile = { ...basicInfo, ...accountInfo };
console.log(vitoProfile);
// { name: 'Vito', age: 28, balance: 3000, accountType: 'Savings' }