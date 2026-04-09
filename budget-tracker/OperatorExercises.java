class OperatorExercises {
    public static void main(String[] args) {
        
        // Exercise 1 - AND operator
        // Capitec teller - bank must be open AND customer must have ID
        boolean bankIsOpen = true;
        boolean hasID = true;
        System.out.println("Exercise 1 - AND operator:");
        System.out.println(bankIsOpen && hasID); // true
        hasID = false;
        System.out.println(bankIsOpen && hasID); // false

        // Exercise 2 - OR operator
        // ATM - customer needs card OR phone
        boolean hasCard = false;
        boolean hasPhone = true;
        System.out.println("\nExercise 2 - OR operator:");
        System.out.println(hasCard || hasPhone); // true
        hasPhone = false;
        System.out.println(hasCard || hasPhone); // false

        // Exercise 3 - NOT operator
        // Transaction flag cleared after review
        boolean isSuspicious = true;
        System.out.println("\nExercise 3 - NOT operator:");
        System.out.println("Before review: " + isSuspicious);
        isSuspicious = !isSuspicious;
        System.out.println("After review: " + isSuspicious);

        // Exercise 4 - Modulus
        // Customers left without a teller
        int customers = 13;
        int tellers = 4;
        System.out.println("\nExercise 4 - Modulus:");
        System.out.println(customers % tellers); // 1

        // Exercise 5 - String concatenation
        // Customer greeting
        String firstName = "Anita";
        int balance = 5000;
        System.out.println("\nExercise 5 - String concatenation:");
        System.out.println("Welcome, " + firstName + "! Your balance is R" + balance);

        // Exercise 6 - += building a string
        // Transaction receipt
        System.out.println("\nExercise 6 - Building a string:");
        String receipt = "";
        receipt += "Capitec Bank\n";
        receipt += "Date: 09 April 2026\n";
        receipt += "Amount: R500\n";
        receipt += "Status: Approved";
        System.out.println(receipt);

        // Exercise 7 - Operator precedence
        // Annual fees calculation
        int monthlyFee = 5;
        int months = 12;
        int bonus = 10;
        System.out.println("\nExercise 7 - Operator precedence:");
        System.out.println(monthlyFee * months + bonus); // 70
    }
}