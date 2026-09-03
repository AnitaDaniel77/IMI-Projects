public class LogicalOperators {

    // helper that prints when it runs, so we can SEE whether it was skipped
    static boolean sideEffect(String label) {
        System.out.println("evaluated: " + label);
        return true;
    }

    public static void main(String[] args) {

        int age = 20;
        boolean isStudent = true;
        boolean hasPaidFees = false;

        // comparison operators: return true/false
        System.out.println("age == 20: " + (age == 20));   // true, equal to
        System.out.println("age != 20: " + (age != 20));   // false, not equal to

        // combining conditions is how real-world rules get written
        boolean canEnrol = (age >= 18) && isStudent;
        System.out.println("canEnrol (age >= 18 AND isStudent): " + canEnrol); // true

        boolean needsRetake = (age < 18) || !hasPaidFees;
        System.out.println("needsRetake: " + needsRetake); // true, fees not paid

        // using variables (not literals) so the compiler still evaluates the left side at runtime
        boolean leftFalse = (age < 0);  // false
        boolean leftTrue = (age > 0);   // true

        // short-circuit AND (&&): right side is NOT run, since false && anything is already false
        boolean andShort = leftFalse && sideEffect("&& right side");
        System.out.println("result: " + andShort);

        // eager AND (&): right side IS run, even though the result is already false
        boolean andEager = leftFalse & sideEffect("& right side");
        System.out.println("result: " + andEager);

        // short-circuit OR (||): right side NOT run, since true || anything is already true
        boolean orShort = leftTrue || sideEffect("|| right side");
        System.out.println("result: " + orShort);

        // eager OR (|): right side IS run, even though result is already true
        boolean orEager = leftTrue | sideEffect("| right side");
        System.out.println("result: " + orEager);

        // prefer && and || in real code — short-circuit also protects you from errors:
        // (count != 0) && (total / count > 10)  — if count is 0, division never happens
    }
}