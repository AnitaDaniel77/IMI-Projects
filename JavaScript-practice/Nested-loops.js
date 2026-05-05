// outer loop counter: 0 to 1
for (var firstNum = 0; firstNum < 2; firstNum++) {
    console.log(firstNum);
}
// Output: 0, 1

// inner loop counter: 0 to 9
for (var secondNum = 0; secondNum < 10; secondNum++) {
    console.log(secondNum);
}
// Output: 0 1 2 3 4 5 6 7 8 9

// nested loops: outer loop counter: 0 to 1, inner loop counter: 0 to 9
for (var firstNum = 0; firstNum < 2; firstNum++) {
    for (var secondNum = 0; secondNum < 10; secondNum++) {
        console.log(firstNum + ", " + secondNum);
    }
}
// Output: 0,0  0,1  0,2 ... 1,7  1,8  1,9

for (var firstNum = 0; firstNum < 2; firstNum++) {
    for (var secondNum = 0; secondNum < 10; secondNum++) {
        console.log(firstNum + " times " + secondNum + " equals " + firstNum * secondNum);
    }
}
// multiplication table for 0 and 1
// Output: 0 times 0 equals 0
//         0 times 1 equals 0
//         ...
//         1 times 8 equals 8
//         1 times 9 equals 9

for (var i = 100; i > 10; i = i - 10) {
    for (var j = 10; j > 4; j = j - 5) {
        console.log(i + " divided by " + j + " equals " + i / j);
    }
}
// Output: 100 divided by 10 equals 10
//         100 divided by 5 equals 20
//         90 divided by 10 equals 9

for (var i = 1; i <= 5; i++) {
    for (var j = 1; j <= 5; j++) {
        console.log(i + " x " + j + " = " + i * j);
    }
}
// multiplication table from 1 to 5
// Output: 1 x 1 = 1
//         1 x 2 = 2        