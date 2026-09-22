public class FunctionsAndMethods {

    // a standalone function-style method: takes two ints, returns their sum
    static int add(int a, int b) {
        return a + b;
    }

    // void method: performs an action but returns nothing
    static void printMessage() {
        System.out.println("Hello World");
    }

    // method with multiple parameters of different types
    static void greet(String name, int age) {
        System.out.println("Hello " + name + ", you are " + age + " years old");
    }

    public static void main(String[] args) {

        int sum = add(5, 3);
        System.out.println(sum); // 8

        printMessage(); // Hello World

        greet("Alice", 30); // Hello Alice, you are 30 years old

        // calling a method that belongs to another class (an object's behavior)
        Calculator calc = new Calculator();
        System.out.println(calc.multiply(4, 5)); // 20

        Rectangle rect = new Rectangle();
        double area = rect.area(4.5, 3.0);
        System.out.println("The area of the rectangle is " + area); // 13.5

        // method overloading: same method name, different parameter types
        Display display = new Display();
        display.show(10);            // uses the int version
        display.show("Hello World"); // uses the String version
    }
}

class Calculator {
    int multiply(int a, int b) {
        return a * b;
    }
}

class Rectangle {
    double area(double width, double height) {
        return width * height;
    }
}

class Display {
    // overload #1: takes an int
    void show(int number) {
        System.out.println(number);
    }

    // overload #2: takes a String — Java picks the right one based on the argument type
    void show(String text) {
        System.out.println(text);
    }
}