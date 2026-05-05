// Refactored Code

// const for a value that never changes
const x = 10;
console.log(x); // 10

// let declared before use — fixes hoisting issue
let a = 20;
console.log(a); // 20

// let inside block — z stays block scoped
if (true) {
    let z = 30;
    console.log(z); // 30 — logged inside the block where it exists
}

// let for a variable that gets reassigned
let b = 40;
b = 50;
console.log(b); // 50

// const for a value that should never change
const PI = 3.14;
console.log(PI); // 3.14