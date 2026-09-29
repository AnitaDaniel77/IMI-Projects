// public class, model is public: anyone can read or change it directly
class Car {
    public String model;
    private String color; // private: only Car's own methods can touch this
    protected int year;   // protected: same package or a subclass elsewhere

    static int totalCarsCreated = 0; // shared across every Car instance

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
        totalCarsCreated++; // every new car bumps the shared count
    }

    void displayInfo() {
        System.out.println(model + " (" + year + "), color: " + color);
    }
}

// abstract class, can't be instantiated on its own
abstract class Shape {
    abstract void draw(); // no body, every subclass must implement this
}

// concrete subclass supplies the actual implementation
class Circle extends Shape {
    void draw() {
        System.out.println("Drawing circle");
    }
}

public class ClassesModifiers {
    public static void main(String[] args) {
        Car myCar = new Car("red", "Sedan", 2024);
        myCar.displayInfo();
        System.out.println("Total cars created: " + Car.totalCarsCreated); // static, no object needed to read it via the class

        Circle c = new Circle();
        c.draw();
    }
}