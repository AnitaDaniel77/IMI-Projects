import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedVsRuntime {

    public static void main(String[] args) {

        // checked: the compiler makes us handle this one
        try {
            File file = new File("nonexistentfile.txt");
            Scanner reader = new Scanner(file);
            System.out.println(reader.nextLine());
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find that file.");
        }

        // runtime: compiles fine, only fails when it runs
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }

        // these two are also runtime, try them one at a time
        String name = null;
        // System.out.println(name.length());  // NullPointerException

        int[] marks = {60, 75, 82};
        // System.out.println(marks[3]);  // ArrayIndexOutOfBoundsException, valid indexes are 0 to 2
    }

    // throws hands the checked exception to whoever calls this method
    static void readReport(String path) throws FileNotFoundException {
        Scanner reader = new Scanner(new File(path));
        reader.close();
    }
}