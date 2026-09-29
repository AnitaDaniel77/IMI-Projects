public class FinalDemo {

    public static void main(String[] args) {

        // final: can only be assigned once
        final int MAX_LOGIN_ATTEMPTS = 3;

        System.out.println("Max attempts: " + MAX_LOGIN_ATTEMPTS);

        // uncomment the line below during the demo to show the compile error live
        // MAX_LOGIN_ATTEMPTS = 5; // ❌ Cannot assign a value to final variable MAX_LOGIN_ATTEMPTS
    }
}