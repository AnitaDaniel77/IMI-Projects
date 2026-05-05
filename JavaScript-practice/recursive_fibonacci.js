// A recursive function that calculates the nth Fibonacci number
// Recursion means the function calls itself to solve smaller parts of the problem
function fib(n) {

    // BASE CASE 1: If n is 0, return 0
    // This is the stopping condition — without it the function would run forever
    // The Fibonacci sequence starts at 0, so fib(0) = 0
    if (n === 0) {
        return 0;
    }

    // BASE CASE 2: If n is 1, return 1
    // The second number in the sequence is 1, so fib(1) = 1
    // This is the second stopping condition
    else if (n === 1) {
        return 1;
    }

    // RECURSIVE CASE: For any number greater than 1
    // Add the two previous Fibonacci numbers together
    // fib(5) = fib(4) + fib(3)
    // fib(4) = fib(3) + fib(2) ... and so on until it hits the base cases
    return fib(n - 1) + fib(n - 2);
}

// TEST 1: Calculate the 5th Fibonacci number
// Sequence: 0, 1, 1, 2, 3, 5 — the 5th number is 5
console.log(fib(5));  // Expected output: 5

// TEST 2: Calculate the 10th Fibonacci number
// Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 — the 10th number is 55
console.log(fib(10)); // Expected output: 55