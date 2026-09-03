public class FizzBuzzRefactored {
    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {

            // calculate these once instead of repeatedly checking i % 3 and i % 5
            boolean divisibleByThree = i % 3 == 0;
            boolean divisibleByFive = i % 5 == 0;

            if (divisibleByThree && divisibleByFive) {
                System.out.println("FizzBuzz");
            } else if (divisibleByThree) {
                System.out.println("Fizz");
            } else if (divisibleByFive) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}