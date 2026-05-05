// Task 1: Function declaration that accepts a and b and console logs a + b
function addTwoNums(a, b) {

    // Task 3: Wrap logic in try...catch block
    try {

        // Task 4: Check if arguments are numbers, throw TypeError if not
        if (typeof a !== 'number') {
            throw new TypeError('The first argument is not a number.');
        } else if (typeof b !== 'number') {
            throw new TypeError('The second argument is not a number.');
        } else {
            // Both arguments are numbers, log the sum
            console.log(a + b);
        }

    // Task 5: Catch block updated to log "Error!" with the error
    } catch(err) {
        console.log("Error!", err);
    }
}

// Task 2: Invoke with a number and a string - results in "55" without type checking
// Task 6: Invoke again with 5 and "5" - now throws TypeError for second argument
addTwoNums(5, "5");

// Task 7: Proves the program keeps running after the error is caught
console.log("It still works");