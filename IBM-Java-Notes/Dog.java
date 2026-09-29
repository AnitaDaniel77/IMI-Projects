public class Dog {
    private String name;
    private int age;

    // no-arg constructor, written by hand so defaults are meaningful, not just null/0
    public Dog() {
        name = "unknown";
        age = 0;
    }

    // parameterized constructor, name only
    public Dog(String dogName) {
        name = dogName;
        age = 0;
    }

    // overloaded again, name and age both provided
    public Dog(String dogName, int dogAge) {
        name = dogName;
        age = dogAge;
    }

    void displayInfo() {
        System.out.println(name + ", age " + age);
    }

    public static void main(String[] args) {
        Dog unnamed = new Dog();               // uses the no-arg constructor
        Dog buddy = new Dog("Buddy");           // uses the name-only constructor
        Dog max = new Dog("Max", 3);            // uses the name-and-age constructor

        unnamed.displayInfo(); // unknown, age 0
        buddy.displayInfo();   // Buddy, age 0
        max.displayInfo();     // Max, age 3
    }
}