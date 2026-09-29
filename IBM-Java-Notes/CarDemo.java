// blueprint for a car object
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println(color + " car is driving");
    }
}

// subclass, inherits color/speed/drive() from Car and adds its own property
class ElectricCar extends Car {
    int batteryLife;
}

// subclass, inherits from Car and adds its own method
class SportsCar extends Car {
    void boost() {
        System.out.println("Accelerating fast!");
    }
}

public class CarDemo {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.color = "red";
        myCar.speed = 180;
        myCar.drive(); // prints: red car is driving

        ElectricCar ev = new ElectricCar();
        ev.color = "blue";
        ev.batteryLife = 320;
        ev.drive(); // inherited method still works

        SportsCar sc = new SportsCar();
        sc.color = "black";
        sc.boost(); // subclass-only method
    }
}