// Plain-Java version of RDBMS ideas: primary keys, foreign keys, a join table and an index
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Db04RdbmsDemo {

    // One row in the students table
    static class Student {
        int studentId; // primary key
        String name;

        Student(int studentId, String name) {
            this.studentId = studentId;
            this.name = name;
        }
    }

    // One row in the courses table
    static class Course {
        int courseId; // primary key
        String title;

        Course(int courseId, String title) {
            this.courseId = courseId;
            this.title = title;
        }
    }

    // Join table row: links one student to one course (many-to-many)
    static class Enrollment {
        int studentId; // foreign key -> students
        int courseId;  // foreign key -> courses

        Enrollment(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }
    }

    // "Tables"
    static List<Student> students = new ArrayList<>();
    static List<Course> courses = new ArrayList<>();
    static List<Enrollment> enrollments = new ArrayList<>();

    // "Index" on studentId: jump straight to the row
    static Map<Integer, Student> studentIndex = new HashMap<>();

    // Primary key rule: no duplicate ids
    static boolean addStudent(Student s) {
        if (studentIndex.containsKey(s.studentId)) {
            System.out.println("Rejected: student id " + s.studentId + " already exists");
            return false;
        }
        students.add(s);
        studentIndex.put(s.studentId, s); // keep the index updated (the small cost of indexes)
        return true;
    }

    static void addCourse(Course c) {
        courses.add(c);
    }

    // Foreign key rule: both ids must exist before linking
    static boolean enroll(int studentId, int courseId) {
        boolean studentExists = studentIndex.containsKey(studentId);
        boolean courseExists = false;
        for (Course c : courses) {
            if (c.courseId == courseId) {
                courseExists = true;
                break;
            }
        }
        if (!studentExists || !courseExists) {
            System.out.println("Rejected: student " + studentId + " or course " + courseId + " doesn't exist");
            return false;
        }
        enrollments.add(new Enrollment(studentId, courseId));
        return true;
    }

    // Full table scan: checks every row one by one
    static Student findWithoutIndex(int studentId) {
        for (Student s : students) {
            if (s.studentId == studentId) {
                return s;
            }
        }
        return null;
    }

    // Index lookup: goes straight to the row
    static Student findWithIndex(int studentId) {
        return studentIndex.get(studentId);
    }

    // Like a SQL JOIN: which courses is this student in?
    static void printCoursesFor(int studentId) {
        Student s = findWithIndex(studentId);
        System.out.println(s.name + " is enrolled in:");
        for (Enrollment e : enrollments) {
            if (e.studentId == studentId) {
                for (Course c : courses) {
                    if (c.courseId == e.courseId) {
                        System.out.println("  - " + c.title);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        addStudent(new Student(1, "Anita"));
        addStudent(new Student(2, "Mia"));
        addStudent(new Student(1, "Duplicate")); // blocked by the primary key

        addCourse(new Course(101, "Java"));
        addCourse(new Course(102, "Databases"));

        enroll(1, 101);
        enroll(1, 102);
        enroll(2, 102);
        enroll(3, 101); // blocked by the foreign key, student 3 doesn't exist

        System.out.println("Scan found: " + findWithoutIndex(2).name);
        System.out.println("Index found: " + findWithIndex(2).name);

        printCoursesFor(1);
    }
}