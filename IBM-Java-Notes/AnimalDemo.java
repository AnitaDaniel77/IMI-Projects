class Animal {
    String name;

    void eat() {
        System.out.println(name + " is eating");
    }

    void sound() {
        System.out.println("Animal makes a sound");
    }
}

// single inheritance: Dog extends Animal directly
class Dog extends Animal {
    void bark() {
        System.out.println(name + " is barking");
    }

    @Override
    void sound() { // method overriding, Dog's own version
        System.out.println("Dog barks");
    }
}

// hierarchical inheritance: Cat also extends Animal, alongside Dog
class Cat extends Animal {
    void meow() {
        System.out.println(name + " says meow");
    }
}

// multilevel inheritance: Puppy extends Dog, which extends Animal
class Puppy extends Dog {
    void play() {
        System.out.println(name + " is playing");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.name = "Buddy";
        myDog.eat();   // inherited from Animal
        myDog.bark();  // Dog's own method
        myDog.sound(); // overridden version, prints "Dog barks"

        // overriding still applies even through the parent type
        Animal genericAnimal = new Dog();
        genericAnimal.sound(); // still "Dog barks", not the generic Animal version

        Cat myCat = new Cat();
        myCat.name = "Whiskers";
        myCat.eat();  // inherited
        myCat.meow(); // Cat's own

        Puppy myPuppy = new Puppy();
        myPuppy.name = "Max";
        myPuppy.eat();  // from Animal, two levels up
        myPuppy.bark(); // from Dog, one level up
        myPuppy.play(); // Puppy's own
    }
}