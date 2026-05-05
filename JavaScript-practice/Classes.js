// ============================================================
// BASE CLASS: Train
// A blueprint for creating train objects
// ============================================================

class Train {

    // constructor runs when a new Train object is created
    // it accepts color and lightsOn as parameters
    constructor(color, lightsOn) {

        // this.color assigns the passed in color to the object's color property
        this.color = color;

        // this.lightsOn assigns the passed in lightsOn value to the object's property
        this.lightsOn = lightsOn;
    }

    // toggleLights flips the lightsOn value between true and false
    // ! is the logical NOT operator — true becomes false, false becomes true
    toggleLights() {
        this.lightsOn = !this.lightsOn;
    }

    // lightsStatus logs the current value of lightsOn to the console
    lightsStatus() {
        console.log('Lights on?', this.lightsOn);
    }

    // getSelf logs the entire object instance — shows all its properties
    getSelf() {
        console.log(this);
    }

    // getPrototype logs all the shared methods that live on the prototype
    getPrototype() {
        var proto = Object.getPrototypeOf(this);
        console.log(proto);
    }
}

// ============================================================
// SUB CLASS: HighSpeedTrain
// Inherits from Train using the extends keyword
// Gets all of Train's methods plus its own additional ones
// ============================================================

class HighSpeedTrain extends Train {

    // constructor accepts four parameters
    // passengers and highSpeedOn are new to HighSpeedTrain
    // color and lightsOn are inherited from Train
    constructor(passengers, highSpeedOn, color, lightsOn) {

        // super() calls the Train constructor
        // this initialises the inherited color and lightsOn properties
        super(color, lightsOn);

        // these two properties are specific to HighSpeedTrain only
        this.passengers = passengers;
        this.highSpeedOn = highSpeedOn;
    }

    // toggleHighSpeed is a new method only available on HighSpeedTrain
    // it flips the highSpeedOn value and logs the new status
    toggleHighSpeed() {
        this.highSpeedOn = !this.highSpeedOn;
        console.log('High speed status:', this.highSpeedOn);
    }

    // toggleLights overrides the Train version — this is polymorphism
    // same method name, different behaviour in the subclass
    toggleLights() {
        // super.toggleLights() calls the original method from Train first
        super.toggleLights();

        // super.lightsStatus() calls Train's lightsStatus to log the updated value
        super.lightsStatus();

        // adds a custom message on top of the inherited behaviour
        console.log('Lights are 100% operational.');
    }
}

// ============================================================
// TESTING THE Train CLASS
// ============================================================

// Create a new Train object — red color, lights off
var myFirstTrain = new Train('red', false);
console.log(myFirstTrain); // Train {color: 'red', lightsOn: false}

// Create two more Train objects — both blue, lights off
var mySecondTrain = new Train('blue', false);
var myThirdTrain = new Train('blue', false);

// Create train4 and test all four methods
var train4 = new Train('red', false);
train4.toggleLights();  // flips lightsOn from false to true
train4.lightsStatus();  // Lights on? true
train4.getSelf();       // Train {color: 'red', lightsOn: true}
train4.getPrototype();  // logs all shared methods on the Train prototype

// ============================================================
// TESTING THE HighSpeedTrain CLASS
// ============================================================

// Create a regular Train — blue, lights off
var train5 = new Train('blue', false);

// Create a HighSpeedTrain — 200 passengers, high speed off, green, lights off
var highSpeed1 = new HighSpeedTrain(200, false, 'green', false);

// train5 uses Train's original toggleLights
train5.toggleLights();  // flips to true — no extra message
train5.lightsStatus();  // Lights on? true

// highSpeed1 uses HighSpeedTrain's overridden toggleLights
highSpeed1.toggleLights();
// Output:
// Lights on? true
// Lights are 100% operational.

// Test toggleHighSpeed — only available on HighSpeedTrain
highSpeed1.toggleHighSpeed(); // High speed status: true

// Compare prototypes of both objects
train5.getPrototype();    // shows Train's methods
highSpeed1.getPrototype(); // shows HighSpeedTrain's methods

// ============================================================
// USING A CLASS INSTANCE INSIDE ANOTHER CLASS
// ============================================================

// StationaryBike class — has position and gears properties
class StationaryBike {
    constructor(position, gears) {
        this.position = position;
        this.gears = gears;
    }
}

// Treadmill class — has position and modes properties
class Treadmill {
    constructor(position, modes) {
        this.position = position;
        this.modes = modes;
    }
}

// Gym class — uses StationaryBike and Treadmill as properties
// This shows that a class instance can be stored inside another class
class Gym {
    constructor(openHrs, stationaryBikePos, treadmillPos) {
        this.openHrs = openHrs;

        // Creates a StationaryBike object and stores it as a property of Gym
        this.stationaryBike = new StationaryBike(stationaryBikePos, 8);

        // Creates a Treadmill object and stores it as a property of Gym
        this.treadmill = new Treadmill(treadmillPos, 5);
    }
}

// Build the boxing gym object
var boxingGym = new Gym("7-22", "right corner", "left corner");

// Log each property of the gym
console.log(boxingGym.openHrs);        // 7-22
console.log(boxingGym.stationaryBike); // StationaryBike {position: 'right corner', gears: 8}
console.log(boxingGym.treadmill);      // Treadmill {position: 'left corner', modes: 5}