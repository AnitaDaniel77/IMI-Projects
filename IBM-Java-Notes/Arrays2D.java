public class Arrays2D {
    public static void main(String[] args) {

        // ===== BASIC ARRAY REVIEW =====

        // declare, then create with 'new' — allocates memory for 5 slots
        int[] numbers;
        numbers = new int[5];

        numbers[0] = 1;
        numbers[4] = 5;

        System.out.println(numbers[0]); // 1
        System.out.println(numbers[4]); // 5

        // modify an existing element by reassigning its index
        numbers[2] = 10;

        // .length tells you how many elements exist
        System.out.println("Array length: " + numbers.length); // 5

        // iterate with a standard for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // ===== TWO-DIMENSIONAL ARRAYS =====

        // int[][] means a grid — an array of arrays
        // each inner {} is one row of the grid
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // accessing a 2D array needs two indices: [row][column]
        System.out.println("matrix[0][1] = " + matrix[0][1]); // 2

        // nested loops: outer loop walks rows, inner loop walks columns within that row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // move to a new line after finishing each row
        }
    }
}