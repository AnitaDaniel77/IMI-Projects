import java.util.Scanner; // needed so Java knows where to find the Scanner class

public class UserInput {

    public static void main(String[] args) {

        // create scanner object, connected to standard keyboard input
        Scanner input = new Scanner(System.in);

        // output the prompt
        System.out.println("enter a line of text");

        // wait for the user to enter a line of text
        String line = input.nextLine();

        // tell them what they entered
        System.out.println("you entered " + line);

        // output the prompt
        System.out.println("enter an integer");

        // wait for the user to enter a whole number
        int value = input.nextInt();

        // tell them what they entered
        System.out.println("you entered " + value);

        // output the prompt
        System.out.println("enter a floating point value");

        // wait for the user to enter a decimal number
        double doubleValue = input.nextDouble();

        // tell them what they entered
        System.out.println("you entered " + doubleValue);
    }
}