public class StaticDemo {

    static class Thing {

        // instance variable every object gets its own separate copy
        public String name;

        // static variable only one copy total, shared by the whole class
        public static String description;

        // static + final = a true constant, can't be reassigned after creation
        public static final int LUCKY_NUMBER = 7;

        // static variable used as a shared counter across all objects
        public static int count = 0;

        // instance variable each object gets its own unique id
        public int id;

        // constructor runs every time a new Thing is created
        public Thing() {
            id = count;   // record count's current value as this object's id
            count++;      // increment the shared counter for the next object
        }

        // instance method can access BOTH instance data (name, id) AND static data (description)
        public void showName() {
            System.out.println("Object id " + id + ": " + description + ", " + name);
        }

        // static method can ONLY access static data, not instance data like name
        public static void showInfo() {
            System.out.println(description);
        }
    }

    public static void main(String[] args) {

        // set the static field once it belongs to the class, not to any one object
        Thing.description = "I am a thing";

        System.out.println("Before creating objects, count is " + Thing.count);

        Thing thing1 = new Thing();
        thing1.name = "Bob";

        Thing thing2 = new Thing();
        thing2.name = "Sue";

        System.out.println("After creating objects, count is " + Thing.count);

        thing1.showName();
        thing2.showName();

        // calling a static method via the class name, not an object
        Thing.showInfo();

        // accessing our static final constant
        System.out.println("Lucky number: " + Thing.LUCKY_NUMBER);
    }
}