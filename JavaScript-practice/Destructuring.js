// Array destructuring — unpacking account details
const anitaDetails = ["Anita", 5000, "Current"];
const [accountHolder, balance, accountType] = anitaDetails;
console.log(`${accountHolder} has a ${accountType} account with R${balance}`);
// Anita has a Current account with R5000

// Object destructuring — unpacking a transaction object
const vitoTransaction = {
    sender: "Vito",
    receiver: "Anita",
    amount: 500,
    date: "2026-04-29"
};

const { sender, receiver, amount, date } = vitoTransaction;
console.log(`${sender} sent R${amount} to ${receiver} on ${date}.`);
// Vito sent R500 to Anita on 2026-04-29.