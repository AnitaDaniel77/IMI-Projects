// ============================================================
// CAPTURING USER INPUT AND UPDATING THE DOM
// WebPageContent.js
// ============================================================


// ============================================================
// METHOD 1 — USING prompt()
// The quickest way to get input from a user
// Shows a popup dialog box asking the user to type something
// ============================================================

// prompt() displays a popup and waits for the user to type
// whatever they type is saved in the answer variable
let answer = prompt('What is your name?');

// Check that the answer is actually a string before using it
// This protects against the user clicking Cancel which returns null
if (typeof(answer) === 'string') {

    // Create a new h1 element in memory
    var h1 = document.createElement('h1');

    // Set the h1 text to whatever the user typed
    h1.innerText = answer;

    // Clear everything currently on the page
    document.body.innerText = '';

    // Add the h1 element to the page
    document.body.appendChild(h1);
}


// ============================================================
// METHOD 2 — DYNAMIC INPUT FORM WITH EVENT LISTENER
// A more flexible approach using a text input field
// The page updates in real time as the user types
// ============================================================

// Step 1 — Create an h1 element with placeholder text
// This is what the user will see before they start typing
var h1 = document.createElement('h1');
h1.innerText = "Type into the input to make this text change";

// Step 2 — Create a text input field
// input.setAttribute sets the HTML type attribute to text
// This makes it a standard text input box on the page
var input = document.createElement('input');
input.setAttribute('type', 'text');

// Step 3 — Clear the page and add both elements
// document.body.innerText = '' removes all existing content
// appendChild adds each element to the bottom of the body
document.body.innerText = '';
document.body.appendChild(h1);
document.body.appendChild(input);

// Step 4 — Add an event listener to the input
// The change event fires when the user types something and presses Enter
// input.value holds whatever the user has typed into the field
// h1.innerText is updated to show the typed text in real time
input.addEventListener('change', function() {
    h1.innerText = input.value;
});


// ============================================================
// REAL LIFE EXAMPLE — CAPITEC BANK GREETING
// Combines DOM manipulation and event handling
// The page greets the user by name after they type it in
// ============================================================

// Create a greeting heading with a default welcome message
var greeting = document.createElement('h1');
greeting.innerText = "Welcome! Please enter your name.";

// Create a text input for the user to type their name
var nameInput = document.createElement('input');
nameInput.setAttribute('type', 'text');

// Add a placeholder hint inside the input box
nameInput.setAttribute('placeholder', 'Enter your name');

// Clear the page and add both the greeting and input
document.body.innerText = '';
document.body.appendChild(greeting);
document.body.appendChild(nameInput);

// Listen for the change event on the name input
// When the user types their name and presses Enter
// the greeting heading updates to welcome them by name
nameInput.addEventListener('change', function() {

    // nameInput.value holds what the user typed
    // template literal builds the personalised greeting message
    greeting.innerText = `Welcome to Capitec, ${nameInput.value}!`;
});

// Try typing "Anita" and pressing Enter
// Output: Welcome to Capitec, Anita!

// Try typing "Vito" and pressing Enter
// Output: Welcome to Capitec, Vito!