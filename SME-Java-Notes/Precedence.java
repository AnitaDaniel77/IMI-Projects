public class Precedence {
    public static void main(String[] args) {

        // no parens: * runs before +
        int withoutParens = 2 + 3 * 4;
        System.out.println("2 + 3 * 4 = " + withoutParens); // 14, not 20

        // parens override default order
        int withParens = (2 + 3) * 4;
        System.out.println("(2 + 3) * 4 = " + withParens); // 20

        // combined expression, read in precedence order not left-to-right
        int combined = 10 + 4 * 2 - 6 / 3;
        System.out.println("10 + 4 * 2 - 6 / 3 = " + combined); // 16
    }
}