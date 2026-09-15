public class Operators {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // ===== ARITHMETIC OPERATORS =====
        System.out.println("Addition " + (a + b));       // 15
        System.out.println("Subtraction " + (a - b));     // 5
        System.out.println("Multiplication " + (a * b));  // 50
        System.out.println("Division " + (a / b));        // 2
        System.out.println("Modulus " + (a % b));          // 0, remainder

        // ===== RELATIONAL OPERATORS (return boolean) =====
        System.out.println("Is a equal to b? " + (a == b));          // false
        System.out.println("Is a not equal to b? " + (a != b));      // true
        System.out.println("Is a greater than b? " + (a > b));       // true
        System.out.println("Is a less than or equal to b? " + (a <= b)); // false

        // ===== LOGICAL OPERATORS =====
        boolean x = true;
        boolean y = false;

        System.out.println("x AND y: " + (x && y));  // false, both must be true
        System.out.println("x OR y: " + (x || y));   // true, at least one is true
        System.out.println("NOT x: " + (!x));         // false, flips true to false
    }
}