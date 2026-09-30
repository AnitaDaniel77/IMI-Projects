// compile-time polymorphism, three overloaded add() methods
class MathOperations {
    int add(int a, int b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, double b) {
        return a + b;
    }
}

// runtime polymorphism setup
class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Cat meows");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        // compile-time: Java picks the right add() based on arguments given
        MathOperations math = new MathOperations();
        System.out.println(math.add(2, 3));         // uses (int, int)
        System.out.println(math.add(2, 3, 4));       // uses (int, int, int)
        System.out.println(math.add(2.5, 3.5));      // uses (double, double)

        // runtime: same reference type, different actual object, different behaviour
        Animal myAnimal = new Dog();
        myAnimal.sound(); // "Dog barks", decided by the real object, not the Animal reference

        myAnimal = new Cat();
        myAnimal.sound(); // "Cat meows", now the real object is a Cat
    }
}