public class Arrays {
    public static void main(String[] args) {

        // declare the array's type, then create it with a fixed size of 3
        int[] values;
        values = new int[3];

        // before assigning anything, numeric array slots default to 0
        System.out.println(values[0]); // 0

        // assign a value to each slot by its index (starts at 0)
        values[0] = 10;
        values[1] = 20;
        values[2] = 30;

        System.out.println(values[0]); // 10
        System.out.println(values[1]); // 20
        System.out.println(values[2]); // 30

        // .length tells you how many slots exist — use it instead of hardcoding the count
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }

        // shorthand: declare and fill an array in one line
        int[] numbers = {5, 6, 7};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}