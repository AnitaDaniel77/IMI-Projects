// ============================================================
// TEST DRIVEN DEVELOPMENT (TDD)
// TDD.js
// Red — Green — Refactor cycle
// ============================================================


// ============================================================
// WHAT IS TDD?
// Write the TEST first before writing any code
// The test fails first (RED) because the code does not exist yet
// Then write just enough code to make the test pass (GREEN)
// Then clean up the code without changing what it does (REFACTOR)
// ============================================================


// ============================================================
// EXAMPLE 1 — statusOfKeys
// Requirement: write a function that accepts a keys variable
// and console logs its value
// ============================================================

// ---- RED PHASE ----
// Write the test FIRST before the function exists
// This test will FAIL because statusOfKeys does not exist yet
// In Jest this would be written in a separate .test.js file
// but we are showing the full TDD thought process here

// test('statusOfKeys function exists', function() {
//     expect(typeof statusOfKeys).toBe('function');
// });
// Result: FAIL — statusOfKeys is not defined

// ---- GREEN PHASE ----
// Write the minimum code needed to make the test pass
// Do not over-engineer — write only what is needed right now

function statusOfKeys(keys) {
    console.log(keys);
}

// Run the test again — it now passes
// typeof statusOfKeys === 'function' is TRUE — GREEN

// ---- REFACTOR PHASE ----
// The function is already clean and simple
// No unnecessary comments or bad indentation
// Run the test one more time to confirm nothing broke — still GREEN


// ============================================================
// EXAMPLE 2 — REAL LIFE CAPITEC BANKING EXAMPLE
// Following the full Red Green Refactor cycle
//
// REQUIREMENT FROM PROJECT MANAGER:
// "Write a function called canWithdraw that accepts a balance
// and an amount. It should return true if the balance is
// enough to cover the withdrawal, and false if it is not."
// ============================================================


// ---- RED PHASE ----
// Step 1: Read the requirement
// Step 2: Write the test BEFORE writing the function
// The test will FAIL because canWithdraw does not exist yet

// In Jest (timesTwo.test.js) you would write:
// const canWithdraw = require('./canWithdraw');
//
// test('returns true if balance covers the withdrawal', function() {
//     expect(canWithdraw(5000, 500)).toBe(true);
// });
//
// test('returns false if balance does not cover the withdrawal', function() {
//     expect(canWithdraw(500, 1000)).toBe(false);
// });
//
// Run npm test — BOTH TESTS FAIL
// canWithdraw is not defined — this is the RED phase
// Red is expected and normal at this stage


// ---- GREEN PHASE ----
// Step 3: Write the minimum code to make both tests pass
// Do not add extra features — only what the requirement asks for

function canWithdraw(balance, amount) {
    // return true if amount is less than or equal to balance
    // return false if amount is greater than balance
    return amount <= balance;
}

// Run npm test again — BOTH TESTS PASS
// canWithdraw(5000, 500) returns true  — 500 <= 5000 GREEN
// canWithdraw(500, 1000) returns false — 1000 <= 500 is false GREEN


// ---- REFACTOR PHASE ----
// Step 4: Clean up the code without changing what it does
// The logic is already clean and readable
// No unnecessary code, good variable names, correct indentation
// Run the tests one final time — still GREEN
// Refactor is complete


// ============================================================
// EXAMPLE 3 — calculateFee
// REQUIREMENT: Write a function that calculates a 2% transaction
// fee on any amount passed in
// Anita transfers money — the fee should be calculated correctly
// ============================================================


// ---- RED PHASE ----
// Write the test first — calculateFee does not exist yet

// test('calculates 2% fee on transaction amount', function() {
//     expect(calculateFee(1000)).toBe(20);  // 2% of 1000 = 20
//     expect(calculateFee(500)).toBe(10);   // 2% of 500 = 10
//     expect(calculateFee(250)).toBe(5);    // 2% of 250 = 5
// });
//
// Run npm test — FAIL
// calculateFee is not defined — RED phase confirmed


// ---- GREEN PHASE ----
// Write the minimum code to make the test pass

function calculateFee(amount) {
    // calculate 2% of the amount and return it
    return amount * 0.02;
}

// Run npm test — ALL PASS
// calculateFee(1000) returns 20  GREEN
// calculateFee(500)  returns 10  GREEN
// calculateFee(250)  returns 5   GREEN


// ---- REFACTOR PHASE ----
// The function is clean and concise
// One line of logic, clear variable name
// Run tests again — still GREEN


// ============================================================
// EXAMPLE 4 — applyDiscount
// REQUIREMENT: Write a function that applies a discount
// percentage to a price and returns the discounted price
// Vito gets a 10% discount on his purchase
// ============================================================


// ---- RED PHASE ----
// Write the test first

// test('applies discount percentage to price', function() {
//     expect(applyDiscount(100, 10)).toBe(90);  // 10% off R100 = R90
//     expect(applyDiscount(200, 20)).toBe(160); // 20% off R200 = R160
//     expect(applyDiscount(50, 50)).toBe(25);   // 50% off R50  = R25
// });
//
// Run npm test — FAIL
// applyDiscount is not defined — RED


// ---- GREEN PHASE ----
// Write the minimum code to pass the tests

function applyDiscount(price, discountPercent) {
    // calculate the discount amount
    const discountAmount = price * (discountPercent / 100);
    // subtract it from the original price
    return price - discountAmount;
}

// Run npm test — ALL PASS
// applyDiscount(100, 10) returns 90  GREEN
// applyDiscount(200, 20) returns 160 GREEN
// applyDiscount(50, 50)  returns 25  GREEN


// ---- REFACTOR PHASE ----
// Simplify the function to one line without changing the result
function applyDiscountRefactored(price, discountPercent) {
    return price * (1 - discountPercent / 100);
}

// Run tests again with the refactored version — still GREEN
// Same result, cleaner code — refactor complete


// ============================================================
// TESTING THE FUNCTIONS MANUALLY
// In a real TDD setup these would be in separate .test.js files
// and run with npm test
// Here we console.log to demonstrate the expected outputs
// ============================================================

console.log("--- statusOfKeys ---");
statusOfKeys(true);  // true
statusOfKeys(false); // false

console.log("--- canWithdraw ---");
console.log(canWithdraw(5000, 500));  // true  — Anita can withdraw R500
console.log(canWithdraw(500, 1000)); // false — Anita cannot withdraw R1000

console.log("--- calculateFee ---");
console.log(calculateFee(1000)); // 20  — R20 fee on R1000 transfer
console.log(calculateFee(500));  // 10  — R10 fee on R500 transfer

console.log("--- applyDiscount ---");
console.log(applyDiscount(100, 10)); // 90  — Vito saves R10 on R100
console.log(applyDiscount(200, 20)); // 160 — Vito saves R40 on R200

console.log("--- applyDiscountRefactored ---");
console.log(applyDiscountRefactored(100, 10)); // 90  — same result cleaner code
console.log(applyDiscountRefactored(200, 20)); // 160 — same result cleaner code


// ============================================================
// TDD SUMMARY
// ============================================================

// RED    — write a failing test before the code exists
//          confirms you know what the code should do
//          confirms the test actually catches failures

// GREEN  — write the minimum code to make the test pass
//          do not add extra features yet
//          just make it work

// REFACTOR — clean up the code without changing the result
//            better variable names, simpler logic, less repetition
//            always run tests after refactoring to confirm nothing broke

// BENEFITS
// - Catches bugs before they reach production
// - Tests become documentation for the team
// - New code cannot silently break old features
// - Forces you to understand requirements before coding