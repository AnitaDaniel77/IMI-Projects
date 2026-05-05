// Function that finds the position of a letter in a word
// Parameters: word (the string to search), match (the letter to find)
function letterFinder(word, match) {

    // Loop through each character in the word
    // i starts at 0 because arrays and strings index from 0
    // Loop runs as long as i is less than the length of the word
    for (var i = 0; i < word.length; i++) {

        // Check if the current letter matches the letter we're looking for
        if (word[i] == match) {
            // If match found, log the letter and its position
            console.log("Found the", match, "at", i);
        } else {
            // If no match, log that no match was found at this position
            console.log("---No match found at", i);
        }
    }
}

// Call the function with "test" as the word and "t" as the letter to find
// Expected output:
// Found the t at 0
// ---No match found at 1
// ---No match found at 2
// Found the t at 3
letterFinder("test", "t");