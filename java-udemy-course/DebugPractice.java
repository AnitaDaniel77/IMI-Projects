public class DebugPractice {

    public static void main(String[] args) {

        System.out.println("Starting");

        int value = 7; // set a breakpoint on this line to start

        value++;             // step over: watch value become 8
        value = value - 8;   // step over: watch value become 0

        DebugPractice.HelperTest test1 = new DebugPractice.HelperTest();

        value = test1.getInitialValue(); // step INTO this to see what happens inside

        test1.doStuff(value); // step into this one too

        System.out.println("Finishing");
    }

    static class HelperTest {

        public int getInitialValue() {
            int number = 5;   // step over this line inside the method
            number += 6;      // watch number become 11
            return number;
        }

        public void doStuff(int number) {
            System.out.println(number); // notice: you can only tell this value by stepping through, not just reading the code
            number = number - 6;
        }
    }
}