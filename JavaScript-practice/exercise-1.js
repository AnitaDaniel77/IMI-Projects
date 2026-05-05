// Exercise 1: Medal Winners

for(var i = 1; i <= 10; i++) {
    if(i == 1) {
        console.log("Gold Medal");
    } else if(i == 2) {
        console.log("Silver Medal");
    } else if(i == 3) {
        console.log("Bronze Medal");
    } else {
        console.log(i);
    }
}
// Output: Gold Medal
//         Silver Medal
//         Bronze Medal

// Refactor the code using a switch statement
switch(i) {
    case 1:
        console.log("Gold Medal");
        break;
    case 2:
        console.log("Silver Medal");
         break;
    case 3:
        console.log("Bronze Medal");
        break;
    default:
        console.log(i);
}


for(var i = 1; i <= 10; i++) {
    switch(i) {
        case 1:
            console.log("Gold Medal");
            break;
        case 2:
            console.log("Silver Medal");
             break;
        case 3:
            console.log("Bronze Medal");
            break;
        default:
            console.log(i);
    }
}
    // Output: Gold Medal
    //         Silver Medal
    //         Bronze Medal
    //         4
    //         5
    //         6
    //         7
    //         8
    //         9
    //         10
}   
