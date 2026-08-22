public class ForLoop {

    public static void main(String[] args) {

        // for loop: setup, condition, and increment all in one line
        // i starts at 0, runs while i < 5, increases by 1 after each lap
        for (int i = 0; i < 5; i++) {

            // %d is a placeholder replaced by the value of i, \n moves to a new line
            System.out.printf("the value of i is %d\n", i);
        }
    }
}