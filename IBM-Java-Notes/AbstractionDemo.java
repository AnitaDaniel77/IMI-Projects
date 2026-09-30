// interface: pure contract, no implementation at all
interface Animal {
    String sound();
}

class Dog implements Animal {
    public String sound() {
        return "Woof";
    }
}

class Cat implements Animal {
    public String sound() {
        return "Meow";
    }
}

// abstract class: mixes an abstract method with a concrete one
abstract class Shape {
    abstract void draw(); // no body, subclasses must implement

    void display() { // concrete, shared as-is unless a subclass overrides it
        System.out.println("Displaying shape");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        // interface in action, polymorphism through a shared contract
        Animal myDog = new Dog();
        Animal myCat = new Cat();
        System.out.println(myDog.sound()); // Woof
        System.out.println(myCat.sound()); // Meow

        // abstract class in action
        Shape myCircle = new Circle();
        myCircle.draw();    // Circle's own implementation
        myCircle.display(); // inherited concrete method from Shape
    }
}
