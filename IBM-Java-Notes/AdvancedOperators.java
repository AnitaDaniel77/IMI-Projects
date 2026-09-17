public class AdvancedOperators {
    public static void main(String[] args) {

        // ===== ASSIGNMENT OPERATORS =====
        int a = 10;

        a += 5; // same as a = a + 5
        System.out.println("New value of a: " + a); // 15

        a *= 2; // same as a = a * 2
        System.out.println("After multiplication, new value of a: " + a); // 30

        // ===== UNARY OPERATORS =====
        int b = 10;

        System.out.println("Unary plus: " + (+b)); // 10, unchanged
        System.out.println("Unary minus: " + (-b)); // -10, flips the sign

        b++; // increment: adds 1
        System.out.println("After increment: " + b); // 11

        b--; // decrement: subtracts 1
        System.out.println("After decrement: " + b); // 10

        // ===== TERNARY OPERATOR =====
        int x = 10;
        int y = 20;

        // shorthand for: if (x > y) { max = x; } else { max = y; }
        int max = (x > y) ? x : y;
        System.out.println("Maximum value is " + max); // 20
    }
}