public class LoopsDemo {
    public static void main(String[] args) {

        // ===== FOR LOOP — iterations known upfront =====
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // ===== WHILE LOOP — condition checked before running =====
        int i = 1;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }

        // ===== DO-WHILE LOOP — runs at least once, checked after =====
        i = 1;
        do {
            System.out.println(i);
            i++;
        } while (i <= 5);

        // ===== NESTED LOOPS — multiplication table =====
        for (int row = 1; row <= 10; row++) {
            for (int col = 1; col <= 10; col++) {
                System.out.print((row * col) + "\t"); // tab for spacing
            }
            System.out.println(); // move to a new line after finishing each row
        }

        // ===== BREAK — exit the loop immediately =====
        int[] numbers = {2, 3, 5, 7, 4};
        for (int num : numbers) {
            if (num > 5) {
                System.out.println("First number greater than 5: " + num);
                break; // stop looking, we found it
            }
        }

        // ===== CONTINUE — skip just this one iteration =====
        for (int n = 1; n <= 10; n++) {
            if (n == 5) {
                continue; // skip printing 5, but keep looping
            }
            System.out.println(n);
        }
    }
}