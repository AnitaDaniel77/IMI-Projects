public class StringOperations {
    public static void main(String[] args) {

        // strings can be created as literals or explicitly with 'new'
        String greeting = "Hello, World!";
        String explicit = new String("Hello, World!");

        // length: total character count, including spaces
        String phrase = "Java Programming";
        System.out.println("Length: " + phrase.length()); // 17

        // charAt: character at a specific index, starting at 0
        System.out.println("First character: " + phrase.charAt(0)); // J

        // concatenation: combining strings with + or .concat()
        String first = "Hello";
        String second = "World";
        System.out.println(first + " " + second);          // Hello World
        System.out.println(first.concat(" ").concat(second)); // Hello World

        // equals: compares content, case-sensitive
        System.out.println("Hello".equals("Hello")); // true
        System.out.println("Hello".equals("World")); // false

        // substring: extract by start index (inclusive) and end index (exclusive)
        System.out.println(phrase.substring(5, 16)); // Programming

        // split: break a string into an array based on a delimiter
        String csv = "apple,banana,cherry";
        String[] fruits = csv.split(",");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // String.join: combine an array back into one string with a separator
        String[] colors = {"Red", "Green", "Blue"};
        System.out.println(String.join(", ", colors)); // Red, Green, Blue

        // immutability: combining strings creates a NEW string, doesn't change the original
        String original = "Hello";
        String combined = original + " World";
        System.out.println(original);  // Hello (unchanged)
        System.out.println(combined);  // Hello World (a new string)

        // built-in helper methods
        System.out.println(phrase.toUpperCase()); // JAVA PROGRAMMING
        System.out.println(phrase.toLowerCase()); // java programming

        String padded = "   trim me   ";
        System.out.println("[" + padded.trim() + "]"); // [trim me]

        System.out.println(phrase.replace("Java", "Python")); // Python Programming
    }
}