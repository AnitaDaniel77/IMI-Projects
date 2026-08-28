public class Loops {
    public static void main(String[] args) {

        // WHILE: condition checked BEFORE each pass
        int countdown = 3;
        while (countdown > 0) {
            System.out.println("while countdown: " + countdown);
            countdown--; // forgetting this causes an infinite loop
        }

        // DO-WHILE: body runs first, condition checked after — runs at least once
        int attempts = 0;
        do {
            attempts++;
            System.out.println("do-while attempt: " + attempts);
        } while (attempts < 1);

        // FOR: init; condition; update all in one line
        for (int i = 0; i < 3; i++) {
            System.out.println("for i = " + i);
        }

        // indexing over an array — classic for-loop job
        String[] names = { "Ada", "Alan", "Grace" };
        for (int i = 0; i < names.length; i++) {
            System.out.println("index " + i + ": " + names[i]);
        }

        // FOR-EACH: cleaner when you only need each element, not the index
        for (String name : names) {
            System.out.println("for-each name: " + name);
        }

        // BREAK: stop searching the moment target is found
        int[] numbers = { 4, 8, 15, 16, 23, 42 };
        int target = 16;
        boolean found = false;

        for (int n : numbers) {
            if (n == target) {
                found = true;
                break; // stop; later numbers are not checked
            }
        }
        System.out.println("found " + target + "? " + found); // true

        // CONTINUE: skip the rest of THIS pass, loop keeps running
        for (int n : numbers) {
            if (n % 2 == 0) {
                continue; // skip even numbers
            }
            System.out.println("odd number: " + n); // 15, 23
        }
    }
}