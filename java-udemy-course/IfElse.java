public class IfElse {

    public static void main(String[] args) {

        // int to test against our conditions
        int myInt = 5;

        // if/else if/else: only the first true branch runs
        if (myInt < 10) {
            System.out.println("it's less than 10");
        } else if (myInt > 20) {
            System.out.println("it's greater than 20");
        } else {
            System.out.println("none of the above");
        }

        // loop counter starts at 0
        int loop = 0;

        // deliberate infinite loop — we control the exit with break instead
        while (true) {

            // break immediately exits the loop when loop reaches 5
            if (loop == 5) {
                break;
            }

            // prints the current loop count before incrementing
            System.out.println("looping " + loop);

            // increment the counter, same as loop = loop + 1
            loop++;
        }
    }
}