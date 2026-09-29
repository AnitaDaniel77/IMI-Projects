import java.util.Scanner;

class Student {
    private String name; // private: only Student's own methods touch this directly
    private int age;
    public String grade; // public: fine for other classes to read/set directly

    void setName(String newName) {
        name = newName;
    }

    String getName() {
        return name;
    }

    void setAge(int newAge) {
        age = newAge;
    }

    int getAge() {
        return age;
    }

    void displayInfo() {
        System.out.println(name + ", age " + age + ", grade " + grade);
    }
}

public class StudentDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // first instance, values typed in by the user
        Student studentOne = new Student();
        System.out.print("Enter first student's name: ");
        studentOne.setName(scanner.nextLine());
        System.out.print("Enter first student's age: ");
        studentOne.setAge(scanner.nextInt());
        scanner.nextLine(); // clear the leftover newline before the next nextLine() call
        studentOne.grade = "Grade 11";

        // second instance, hardcoded so we have something to compare against
        Student studentTwo = new Student();
        studentTwo.setName("Zanele");
        studentTwo.setAge(16);
        studentTwo.grade = "Grade 10";

        studentOne.displayInfo();
        studentTwo.displayInfo();

        // compare the two instances, each holds its own separate data
        if (studentOne.getAge() > studentTwo.getAge()) {
            System.out.println(studentOne.getName() + " is older");
        } else if (studentTwo.getAge() > studentOne.getAge()) {
            System.out.println(studentTwo.getName() + " is older");
        } else {
            System.out.println("Both students are the same age");
        }

        scanner.close();
    }
}