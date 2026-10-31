public class IntellijPractice {

    // practise: set a breakpoint on the line inside this loop
    static double totalOf(double[] amounts) {
        double total = 0;
        for (double amount : amounts) {
            total += amount;
        }
        return total;
    }

    // practise: rename this method with Shift+F6 and watch the call update
    static boolean isLarge(double amount) {
        return amount > 10000;
    }

    public static void main(String[] args) {
        double[] amounts = {250.00, 12000.00, 800.50};
        double total = totalOf(amounts);

        System.out.println("Total: " + total);
        System.out.println("Large? " + isLarge(total));
    }
}