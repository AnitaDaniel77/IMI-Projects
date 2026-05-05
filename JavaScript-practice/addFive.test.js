// Import the addFive function from addFive.js
const addFive = require('./addFive');

// Test that the function returns the correct value
test('returns the number plus five', function() {
    expect(addFive(3)).toBe(8);   // 3 + 5 = 8
    expect(addFive(10)).toBe(15); // 10 + 5 = 15
    expect(addFive(0)).toBe(5);   // 0 + 5 = 5
});