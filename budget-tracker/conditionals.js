var  age = 25

if ( age >= 65) {
    console.log( "You get your income from your pension")
} else if ( age < 65 && age >= 18) {
    console.log( "Each month you get a salary")
} else if ( age < 18) {
    console.log( "You get an allowance")
} else {
    console.log("The value of the age variable is not numerical")
}
var day = "Holiday"

switch(day) {
    case "Monday":
    console.log("Go to the gym");
    break;
    case "Tuesday":
    console.log("Go to the office");
    break;
    case "Wednesday":
    console.log("Go to the main house");
    break;              
    case "Thursday":
    console.log("Go to back to my apartment");
    break;                      
    case "Friday":
    console.log("Go to the restaurant");
    break;                      
    case "Saturday":                                            
    console.log("Go to the salon");
    break;                      
    case "Sunday":
    console.log("Go to the kizomba social");
    break;                      
     default:
     console.log("There is no such day")
}