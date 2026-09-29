public class Person {
    // private: nothing outside this class can read or change these directly
    private String name;
    private int age;

    // constructor, sets initial values when the object is created
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getters, the public "read" access point
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // setters, the public "write" access point, with validation
    public void setName(String newName) {
        name = newName;
    }

    public void setAge(int newAge) {
        if (newAge < 0) {
            System.out.println("Error: age cannot be negative");
        } else {
            age = newAge;
        }
    }

    public static void main(String[] args) {
        Person p = new Person("Alice", 30);

        System.out.println(p.getName() + " is " + p.getAge()); // read through getters

        p.setAge(31); // valid update, goes through
        System.out.println(p.getName() + " is now " + p.getAge());

        p.setAge(-5); // invalid, setter blocks it, age stays 31
        System.out.println(p.getName() + " is still " + p.getAge());
    }
}