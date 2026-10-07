import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateFormattingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your name:");
        String name = scanner.nextLine();

        System.out.println("Enter your birthdate (yyyy-MM-dd):");
        String input = scanner.nextLine();
        LocalDate birthdate = LocalDate.parse(input); // turns the typed string into a real LocalDate

        // format it into something friendly to show back to the user
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy");
        String formatted = birthdate.format(formatter);

        System.out.println("Hello " + name + ", your birthdate is " + formatted);

        // a few other common patterns on today's date, just to compare
        LocalDate today = LocalDate.now();
        System.out.println(today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
        System.out.println(today.format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));

        scanner.close();
    }
}
