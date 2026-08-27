import java.util.Scanner; // needed to read user input

public class DoWhile {

    public static void main(String[] args) {

        // scanner to read input from the keyboard
        try (Scanner input = new Scanner(System.in)) {
            // declared here (outside the loop) so both the loop body and the condition can see it — this is variable scope in action
            int value = 0;

            // do-while: runs the block first, checks the condition after
            do {
                // prompt the user
                System.out.println("enter a number");

                // read their input
                value = input.nextInt();

            } while (value != 5); // keep looping as long as value is not 5

            // only reached once value equals 5
            System.out.println("got five");
        }
    }
}