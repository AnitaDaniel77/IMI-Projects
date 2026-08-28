public class ArithmeticOperatorsAndExpressions {
    public static void main(String[] args) {

        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b)); // 13
        System.out.println("a - b = " + (a - b)); // 7
        System.out.println("a * b = " + (a * b)); // 30
        System.out.println("a / b = " + (a / b)); // 3
        System.out.println("a % b = " + (a % b)); // 1 remainder

        // both operands int -> integer division, decimal part discarded
        int intDivision = 7 / 2;
        System.out.println("7 / 2 (int) = " + intDivision); // 3, not 3.5

        // at least one operand a double -> real decimal result
        double floatDivision = 7.0 / 2;
        System.out.println("7.0 / 2 (double) = " + floatDivision); // 3.5

        // casting one operand forces float division even from two ints
        double castDivision = (double) 7 / 2;
        System.out.println("(double) 7 / 2 = " + castDivision); // 3.5
    }
}