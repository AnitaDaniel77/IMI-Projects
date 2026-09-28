public class FinallyBlockDemo {

    public static void main(String[] args) {

        // ===== CORRECT USAGE: finally for guaranteed cleanup =====
        try {
            int result = 10 / 0; // throws ArithmeticException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("In try block, caught an exception, / by 0");
        } finally {
            System.out.println("finally block executed"); // always runs
        }

        // ===== CORRECT USAGE PATTERN: resource cleanup (illustrative) =====
        // a real file/database example follows this same shape:
        // try { open the resource, use it }
        // catch { handle the failure }
        // finally { close the resource, whether it succeeded or not }

        // ===== INCORRECT USAGE #1: an exception inside finally hides the original one =====
        try {
            demonstrateSuppressedException();
        } catch (Exception e) {
            System.out.println("Caught (but this might not be the ORIGINAL problem): " + e.getMessage());
        }

        // ===== INCORRECT USAGE #2: return inside finally overrides everything =====
        System.out.println("Result of trickyReturn(): " + trickyReturn()); // always prints 3
    }

    static void demonstrateSuppressedException() {
        try {
            throw new RuntimeException("original problem: something went wrong in try");
        } finally {
            // BAD PRACTICE: this new exception hides the original one above
            throw new RuntimeException("a NEW problem happened in finally");
        }
    }

    static int trickyReturn() {
        try {
            return 1; // this return is set up but not yet finalized
        } catch (Exception e) {
            return 2; // this would also be overridden
        } finally {
            return 3; // BAD PRACTICE: this wins, no matter what — always returns 3
        }
    }
}