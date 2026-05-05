const addTwoNums = require('./addTwoNums');

test('adds two numbers correctly', function() {
    expect(addTwoNums(2, 3)).toBe(5);
});