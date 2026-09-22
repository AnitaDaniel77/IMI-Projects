public class ExceptionHandling {

    public static void main(String[] args) {

        // ===== BASIC TRY-CATCH-FINALLY =====
        int numerator = 10;
        int denominator = 0;

        try {
            int result = numerator / denominator; // this throws an ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: cannot divide by zero.");
        } finally {
            System.out.println("This runs no matter what good for cleanup.");
        }

        // ===== UNCHECKED EXCEPTION EXAMPLE: array index out of bounds =====
        int[] numbers = {1, 2, 3};
        try {
            System.out.println(numbers[5]); // index doesn't exist
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: tried to access an index that doesn't exist.");
        }

        // ===== UNCHECKED EXCEPTION EXAMPLE: null pointer =====
        String text = null;
        try {
            System.out.println(text.length()); // calling a method on a null reference
        } catch (NullPointerException e) {
            System.out.println("Error: tried to use a null reference.");
        }

        // ===== CUSTOM EXCEPTION =====
        try {
            validateAge(-5);
        } catch (InvalidAgeException e) {
            System.out.println("Custom error: " + e.getMessage());
        }
    }

    // a method that throws our custom exception when given bad input
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative.");
        }
        System.out.println("Age is valid: " + age);
    }
}

// custom checked exception: extends Exception
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message); // pass the message up to Exception's own constructor
    }
}