public class Loops {

    public static void main(String[] args) {

        // int to hold our counter, starts at 0
        int value = 0;

        // while loop: keeps running as long as this condition is true
        while (value < 10) {

            // print "hello" plus the current counter value
            System.out.println("hello " + value);

            // increase the counter by 1 each time through the loop
            value = value + 1;
        }
    }
}