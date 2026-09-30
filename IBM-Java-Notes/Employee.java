public class Employee implements Cloneable {
    private String name;
    private int age;
    private double salary; // stored as monthly

    // no-arg constructor, delegates to the full one with safe defaults
    public Employee() {
        this("Unnamed", 18, 0.0);
    }

    // name only, delegates with defaults for age and salary
    public Employee(String name) {
        this(name, 18, 0.0);
    }

    // name and age, delegates with a default salary
    public Employee(String name, int age) {
        this(name, age, 0.0);
    }

    // full constructor, all validation lives here since every other constructor delegates to it
    public Employee(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18 || age > 65) {
            throw new IllegalArgumentException("Age must be between 18 and 65");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public double calculateAnnualSalary() {
        return salary * 12;
    }

    public void giveRaise(double percentage) {
        if (percentage <= 0) {
            throw new IllegalArgumentException("Raise percentage must be positive");
        }
        salary = salary + (salary * percentage / 100);
    }

    // makes a separate copy, changing the clone never affects the original
    @Override
    public Employee clone() {
        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            // won't actually happen, this class implements Cloneable
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return name + ", age " + age + ", monthly salary R" + salary;
    }
}