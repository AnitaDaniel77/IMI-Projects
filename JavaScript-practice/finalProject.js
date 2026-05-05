// Dishes Data
const dishData = [
    { name: "Italian pasta", price: 9.55 },
    { name: "Rice with veggies", price: 8.65 },
    { name: "Chicken with potatoes", price: 15.55 },
    { name: "Vegetarian Pizza", price: 6.45 },
];

// Tax Value
const tax = 1.20;

// Task 1: Implement getPrices()
// taxBoolean parameter determines whether tax is added or not
function getPrices(taxBoolean) {

    // Step 3: Loop over every dish in the dishData array
    for (var i = 0; i < dishData.length; i++) {

        // Step 4: Declare finalPrice without assigning a value yet
        var finalPrice;

        // Step 5: If taxBoolean is true — calculate price WITH tax
        if (taxBoolean === true) {
            // Multiply price by 1.20 to add 20% tax
            // toFixed(2) rounds to 2 decimal places
            finalPrice = (dishData[i].price * tax).toFixed(2);

        // Step 6: If taxBoolean is false — use price WITHOUT tax
        } else if (taxBoolean === false) {
            // No tax applied — just use the original price
            finalPrice = dishData[i].price.toFixed(2);

        // Step 7: If taxBoolean is neither true nor false — invalid input
        } else {
            // Log an error message to warn the user
            console.log("You need to pass a boolean to the getPrices call!");
            // Return exits the function immediately
            return;
        }

        // Step 8: Log the dish name and final price to the console
        console.log("Dish: " + dishData[i].name + " Price: $" + finalPrice);
    }
}

// Task 2: Implement getDiscount()
// taxBoolean is passed to getPrices
// guests determines the discount amount
function getDiscount(taxBoolean, guests) {

    // Step 10: Call getPrices first to display all dish prices
    getPrices(taxBoolean);

    // Step 11: Defensive coding — validate the guests argument
    // Check that guests is a number AND greater than 0 AND less than 30
    if (typeof guests === 'number' && guests > 0 && guests < 30) {

        // Step 12: Start discount at 0
        var discount = 0;

        // If fewer than 5 guests — discount is $5
        if (guests < 5) {
            discount = 5;

        // If 5 or more guests — discount is $10
        } else if (guests >= 5) {
            discount = 10;
        }

        // Log the final discount amount
        console.log("Discount is: $" + discount);

    // Step 13: If guests input is invalid — log an error message
    } else {
        console.log("The second argument must be a number between 0 and 30");
    }
}

// Step 14: Test the function with different arguments
// true = prices with tax, 2 guests = $5 discount
getDiscount(true, 2);

// false = prices without tax, 10 guests = $10 discount
getDiscount(false, 10);