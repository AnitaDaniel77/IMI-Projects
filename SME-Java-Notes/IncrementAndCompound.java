public class IncrementAndCompound {
    public static void main(String[] args) {

        int score = 5;

        // prefix: increments FIRST, then uses the value
        System.out.println("prefix ++score = " + (++score)); // 6

        // postfix: uses the CURRENT value first, then increments
        System.out.println("postfix score++ = " + (score++)); // 6
        System.out.println("score after postfix = " + score); // 7

        int total = 10;
        total += 5; // same as total = total + 5
        System.out.println("after += 5: " + total); // 15

        total -= 3;
        System.out.println("after -= 3: " + total); // 12

        total *= 2;
        System.out.println("after *= 2: " + total); // 24

        total /= 4;
        System.out.println("after /= 4: " + total); // 6

        total %= 4;
        System.out.println("after %= 4: " + total); // 2
    }
}