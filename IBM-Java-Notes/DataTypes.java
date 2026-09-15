public class DataTypes {
    public static void main(String[] args) {

        // ===== PRIMITIVE DATA TYPES =====

        byte age = 25; // -128 to 127, memory-efficient for small values
        short temperature = -5; // -32,768 to 32,767
        int population = 1000000; // most commonly used whole-number type
        long distanceToMoon = 384400000L; // L suffix required for long literals
        float price = 19.99F; // F suffix required, ~7 decimal digits precision
        double pi = 3.141592653589793; // ~15 decimal digits precision
        char initial = 'A'; // a single character
        boolean loggedIn = true; // true or false only

        System.out.println("age: " + age);
        System.out.println("temperature: " + temperature);
        System.out.println("population: " + population);
        System.out.println("distanceToMoon: " + distanceToMoon);
        System.out.println("price: " + price);
        System.out.println("pi: " + pi);
        System.out.println("initial: " + initial);
        System.out.println("loggedIn: " + loggedIn);

        // ===== REFERENCE DATA TYPES =====

        // String: a sequence of characters
        String greeting = "Hello, World!";
        System.out.println(greeting);

        // Array: multiple values of the same type, one variable, indexed from 0
        int[] scores = {85, 90, 78, 92};
        System.out.println("First score: " + scores[0]);

        // Class: a blueprint for objects (defined separately below)
        Person person = new Person("Anita");
        System.out.println(person.greet());

        // Enum: a fixed set of named values
        Day today = Day.MONDAY;
        System.out.println("Today is " + today);
    }
}

// a simple class demonstrating a reference type
class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    String greet() {
        return "Hi, I'm " + name;
    }
}

// an enum: a fixed set of named constants
enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}