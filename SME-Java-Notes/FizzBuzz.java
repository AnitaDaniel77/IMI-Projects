public class FizzBuzz {
    public static void main(String[] args) {

        // FizzBuzz prints numbers from 1 to 15, but for multiples of 3 prints "Fizz" instead of the number,
        // and for multiples of 5 prints "Buzz". For numbers which are multiples of both 3 and 5, it prints "FizzBuzz".

        for (int i = 1; i <= 15; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }
}