public class ClassesAndObjects {
    public static void main(String[] args) {

        // a class is a BLUEPRINT: describes what every Student looks like (fields)
        // and what every Student can do (methods).
        // an object is one CONCRETE instance built from that blueprint, created with 'new'.

        // studentOne and studentTwo are variables — each holds a REFERENCE
        // to a separate Student object living on the heap.
        // Two objects, same class, completely separate data.

        Student studentOne = new Student();
        studentOne.name = "Ada";
        studentOne.mark = 88;

        Student studentTwo = new Student();
        studentTwo.name = "Alan";
        studentTwo.mark = 72;

        System.out.println(studentOne.describe()); // Ada scored 88
        System.out.println(studentTwo.describe()); // Alan scored 72

        // changing one object does NOT change the other
        studentOne.mark = 95;
        System.out.println("After update:");
        System.out.println(studentOne.describe()); // Ada scored 95
        System.out.println(studentTwo.describe()); // Alan scored 72 (unchanged)

        // constructor: sets fields at the moment of creation, instead of one at a time
        Student mainStudent = new Student("Hilbert", 100);
        System.out.println(mainStudent.describe());
    }
}

// a simple demo type for this lesson
class Student {

    // fields: the state of one Student object
    String name;
    int mark;
    private String _idNumber; // private field: only accessible from within this class

    // constructor: builds a Student with name and mark already set
    public Student(String name, int mark) {
        this.name = name; // "this.name" is the field, "name" is the constructor's parameter
        this.mark = mark;
    }

    // default constructor, so "new Student()" without arguments still works
    public Student() {
    }

    // method: behavior that uses this object's fields
    String describe() {
        return name + " scored " + mark;
    }

    boolean hasPassed() {
        return mark >= 50;
    }
}