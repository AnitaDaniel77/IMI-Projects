public class TernaryOperator {
    public static void main(String[] args) {

        int score = 72;
        int passingMark = 50;
        boolean isStudent = true;

        // ternary: condition ? valueIfTrue : valueIfFalse — a one-line if/else that returns a value
        String result = (score >= passingMark) ? "pass" : "fail";
        System.out.println("ternary result: " + result); // pass

        int discount = isStudent ? 10 : 0;
        System.out.println("student discount: " + discount); // 10
    }
}