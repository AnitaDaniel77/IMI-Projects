public class ConditionalStatements {
    public static void main(String[] args) {

        // ===== IF =====
        int number = 10;
        if (number > 5) {
            System.out.println("The number is greater than 5");
        }

        // ===== IF-ELSE =====
        number = 3;
        if (number > 5) {
            System.out.println("The number is greater than 5");
        } else {
            System.out.println("The number is not greater than 5");
        }

        // ===== ELSE-IF =====
        number = 5;
        if (number > 5) {
            System.out.println("The number is greater than 5");
        } else if (number == 5) {
            System.out.println("The number equals 5");
        } else {
            System.out.println("The number is less than 5");
        }

        // ===== SWITCH =====
        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            default:
                System.out.println("Weekend"); // fallback if no case matches
        }

        // ===== NESTED CONDITIONALS =====
        int age = 20;
        if (age >= 18) {
            System.out.println("You are an adult");

            // nested if: only checked because the outer condition was already true
            if (age >= 65) {
                System.out.println("You are a senior citizen");
            }
        } else {
            System.out.println("You are a minor");
        }
    }
}