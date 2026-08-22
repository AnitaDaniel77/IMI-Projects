public class Application {

    public static void main(String[] args) {

        // int is primitive, lowercase — a raw number
        int myInt = 7;

        // String is NOT primitive, capital S — it's a class, and text is an object of that class
        String text = "hello";

        // another String, just holding a single space character
        String blank = " ";

        // another String, holding a name
        String name = "Bob";

        // concatenation: joining strings together with +
        String greeting = text + blank + name;

        // prints "hello Bob"
        System.out.println(greeting);

        // you don't need separate variables — you can concatenate literals directly too
        System.out.println("hello" + " " + "Bob");

        // concatenating a String with an int — Java converts the int to text automatically
        System.out.println("my integer is " + myInt);

        // same idea works with a double
        double myDouble = 7.8;
        System.out.println("my number is " + myDouble);
    }
}