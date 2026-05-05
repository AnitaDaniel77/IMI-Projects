// ============================================================
// ANIMAL CLASS HIERARCHY
// Think of it like a family tree
//
//         Animal (grandparent)
//         /                \
//       Cat               Bird
//      /    \               \
// HouseCat  Tiger          Parrot
//
// Every animal inherits color and energy from Animal
// Each child class adds its own special properties on top
// ============================================================


// ============================================================
// ANIMAL — THE GRANDPARENT CLASS
// Every single animal gets color and energy from here
// All other classes inherit these automatically
// ============================================================

class Animal {

    // constructor sets up color and energy for every animal
    // default color is yellow and default energy is 100
    // if no values are passed these defaults kick in
    constructor(color = 'yellow', energy = 100) {
        this.color = color;
        this.energy = energy;
    }

    // isActive runs when the animal is doing something
    // every time it runs the animal loses 20 energy
    // if energy hits 0 the animal automatically goes to sleep
    isActive() {
        if (this.energy > 0) {
            this.energy -= 20;
            console.log('Energy is decreasing, currently at:', this.energy);
        } else if (this.energy == 0) {
            this.sleep(); // energy is 0 so force the animal to sleep
        }
    }

    // sleep runs when the animal rests
    // every time it runs the animal gains 20 energy back
    sleep() {
        this.energy += 20;
        console.log('Energy is increasing, currently at:', this.energy);
    }

    // getColor simply logs the color of the animal
    getColor() {
        console.log(this.color);
    }
}


// ============================================================
// CAT — INHERITS FROM ANIMAL
// A cat is still an animal so it gets color and energy for free
// But it also has its own sound, canJumpHigh and canClimbTrees
// ============================================================

class Cat extends Animal {

    // constructor adds cat specific properties on top of Animal's
    // sound defaults to purr, canJumpHigh and canClimbTrees default to true
    constructor(sound = 'purr', canJumpHigh = true, canClimbTrees = true, color, energy) {

        // super() passes color and energy up to Animal to handle
        // Animal's constructor assigns them to the object
        super(color, energy);

        this.sound = sound;
        this.canJumpHigh = canJumpHigh;
        this.canClimbTrees = canClimbTrees;
    }

    // makeSound logs the cat's sound — purr by default
    makeSound() {
        console.log(this.sound);
    }
}


// ============================================================
// BIRD — ALSO INHERITS FROM ANIMAL
// A bird is an animal too so it gets color and energy for free
// But it has its own sound and canFly property
// ============================================================

class Bird extends Animal {

    // constructor adds bird specific properties on top of Animal's
    // sound defaults to chirp and canFly defaults to true
    constructor(sound = 'chirp', canFly = true, color, energy) {

        // super() passes color and energy up to Animal to handle
        super(color, energy);

        this.sound = sound;
        this.canFly = canFly;
    }

    // makeSound logs the bird's sound — chirp by default
    makeSound() {
        console.log(this.sound);
    }
}


// ============================================================
// HOUSECAT — INHERITS FROM CAT
// A house cat is a type of cat so it gets everything from Cat
// It adds its own houseCatSound on top — meow by default
// ============================================================

class HouseCat extends Cat {

    // constructor adds houseCatSound on top of Cat's properties
    // houseCatSound defaults to meow
    constructor(houseCatSound = "meow", sound, canJumpHigh, canClimbTrees, color, energy) {

        // super() passes all the Cat properties up to Cat to handle
        super(sound, canJumpHigh, canClimbTrees, color, energy);

        this.houseCatSound = houseCatSound;
    }

    // makeSound has two behaviours depending on the option argument
    // option = true  means BOTH purr (from Cat) AND meow
    // option = false means ONLY meow
    makeSound(option) {
        if (option) {
            super.makeSound(); // borrows purr from Cat — only runs if option is true
        }
        console.log(this.houseCatSound); // meow — always runs regardless of option
    }
}


// ============================================================
// TIGER — ALSO INHERITS FROM CAT
// A tiger is a type of cat so it gets everything from Cat
// It adds its own tigerSound — Roar! by default
// ============================================================

class Tiger extends Cat {

    // constructor adds tigerSound on top of Cat's properties
    // tigerSound defaults to Roar!
    constructor(tigerSound = "Roar!", sound, canJumpHigh, canClimbTrees, color, energy) {

        // super() passes all the Cat properties up to Cat to handle
        super(sound, canJumpHigh, canClimbTrees, color, energy);

        this.tigerSound = tigerSound;
    }

    // makeSound has two behaviours depending on the option argument
    // option = true  means BOTH purr (from Cat) AND Roar!
    // option = false means ONLY Roar!
    makeSound(option) {
        if (option) {
            super.makeSound(); // borrows purr from Cat — only runs if option is true
        }
        console.log(this.tigerSound); // Roar! — always runs regardless of option
    }
}


// ============================================================
// PARROT — INHERITS FROM BIRD
// A parrot is a type of bird so it gets everything from Bird
// It adds canTalk — some parrots talk, some do not
// ============================================================

class Parrot extends Bird {

    // constructor adds canTalk on top of Bird's properties
    // canTalk defaults to false — parrots cannot talk unless told otherwise
    constructor(canTalk = false, sound, canFly, color, energy) {

        // super() passes all the Bird properties up to Bird to handle
        super(sound, canFly, color, energy);

        this.canTalk = canTalk;
    }

    // makeSound has two behaviours
    // option = true means chirp (from Bird) runs first
    // then if canTalk is true the parrot also says it can talk
    makeSound(option) {
        if (option) {
            super.makeSound(); // borrows chirp from Bird — only runs if option is true
        }
        if (this.canTalk) {
            console.log("I'm a talking parrot!"); // only runs if canTalk is true
        }
    }
}


// ============================================================
// TESTING PARROTS
// polly can talk, fiji cannot
// ============================================================

var polly = new Parrot(true);  // canTalk is true — polly can talk
var fiji = new Parrot(false);  // canTalk is false — fiji cannot talk

polly.makeSound();      // I'm a talking parrot!
polly.makeSound(true);  // chirp, I'm a talking parrot!

fiji.makeSound();       // nothing — canTalk is false and option not passed
fiji.makeSound(true);   // chirp — option is true so chirp runs but no talking

// checking inherited Animal properties on polly
polly.color;    // yellow — inherited from Animal default
polly.energy;   // 100 — inherited from Animal default

polly.isActive(); // Energy is decreasing, currently at: 80


// ============================================================
// TESTING BIRD — PENGUIN CANNOT FLY
// canFly is set to false — overrides the default of true
// ============================================================

var penguin = new Bird("shriek", false, "black and white", 200);

penguin.sound;    // shriek
penguin.canFly;   // false
penguin.color;    // black and white
penguin.energy;   // 200

penguin.isActive(); // Energy is decreasing, currently at: 180


// ============================================================
// TESTING HOUSECAT
// leo is a house cat — purrs and meows
// ============================================================

var leo = new HouseCat();

leo.makeSound(false); // meow — only the house cat sound
leo.makeSound(true);  // purr, meow — purr from Cat then meow from HouseCat


// ============================================================
// TESTING TIGER
// cuddles is a tiger — purrs and roars
// ============================================================

var cuddles = new Tiger();

cuddles.makeSound(false); // Roar! — only the tiger sound
cuddles.makeSound(true);  // purr, Roar! — purr from Cat then Roar from Tiger