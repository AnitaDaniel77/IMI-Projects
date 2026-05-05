function letterFinder(word, match) {
    // Task 1
    var condition1 = typeof(word) == 'string' && word.length >= 2;
    
    // Task 2
    var condition2 = typeof(match) == 'string' && match.length == 1;
    
    // Task 3 & 4
    if (condition1 && condition2) {
        for(var i = 0; i < word.length; i++) {
            if(word[i] == match) {
                console.log('Found the', match, 'at', i)
            } else {
                console.log('---No match found at', i)
            }
        }
    } else {
        // Task 5
        console.log("Please pass correct arguments to the function.");
    }
}

// Task 6: failing test - passing numbers instead of strings
letterFinder(1, 2);

// Task 7: passing test - correct arguments
letterFinder("cat", "c");