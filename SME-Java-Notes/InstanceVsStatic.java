public class InstanceVsStatic {

    // reminder: main is static so the JVM can call it without creating an object.
    // the same idea applies to any static member: it belongs to the CLASS, not one instance.

    public static void main(String[] args) {

        // INSTANCE = PER OBJECT
        // instance fields live inside EACH object. Change one object's label — the other is untouched.
        Widget first = new Widget("Alpha");
        Widget second = new Widget("Beta");

        System.out.println(first.describe());  // Widget Alpha
        System.out.println(second.describe()); // Widget Beta

        first.rename("Alpha-2");
        System.out.println("After rename:");
        System.out.println(first.describe());  // Widget Alpha-2
        System.out.println(second.describe()); // Widget Beta (unchanged)

        // STATIC = PER CLASS
        // a static field is SHARED by the whole class. There is one copy, not one per object.
        // call static members via the CLASS name you do not need 'new' to read them.
        System.out.println("Widgets created: " + Widget.getCreatedCount()); // 2

        Widget third = new Widget("Gamma");
        System.out.println("Widgets created: " + Widget.getCreatedCount()); // 3

        // every object sees the SAME static count
        System.out.println(first.describe() + " | total so far: " + Widget.getCreatedCount());
        System.out.println(third.describe() + " | total so far: " + Widget.getCreatedCount());

        // STATIC METHOD
        // a static method cannot use instance fields directly it has no 'this' object.
        // it can only use static data, or values you pass in as arguments.
        System.out.println(Widget.classMotto()); // Build once. Reuse often.

        // KEY TAKEAWAY
        // Instance belongs to each object (label, rename, describe).
        // Static   belongs to the class (createdCount, getCreatedCount).
        // Prefer ClassName.staticThing for clarity.
        // main is static for the same reason: the JVM calls it with no instance.
        // Rule of thumb: does this data/behaviour need a specific object? -> instance
        //                is it about the class as a whole?                -> static
    }
}

class Widget {

    // instance field: each Widget has its own label.
    String label;

    // static field: one shared counter for the whole Widget class.
    private static int createdCount = 0;

    Widget(String label) {
        this.label = label;
        createdCount++; // every new Widget bumps the shared count
    }

    // instance method: uses THIS object's fields.
    void rename(String newLabel) {
        this.label = newLabel;
    }

    String describe() {
        return "Widget " + label;
    }

    // static method: no 'this'. Speaks for the class.
    static int getCreatedCount() {
        return createdCount;
    }

    static String classMotto() {
        return "Build once. Reuse often.";
    }
}