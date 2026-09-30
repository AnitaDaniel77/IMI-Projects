public class InnerClassesDemo {

    // outer class with a plain field
    static int staticVar = 5;
    int outerVariable = 10;

    // non-static inner class, needs an outer instance to exist
    class InnerClass {
        void display() {
            System.out.println(outerVariable); // reads straight from the outer object
        }
    }

    // static nested class, no outer instance needed, only sees static members
    static class StaticNestedClass {
        void show() {
            System.out.println(staticVar);
        }
    }

    void myMethod() {
        // method-local inner class, only exists inside this method
        class MethodLocalInner {
            void display() {
                System.out.println("Inside Method Local Inner Class");
            }
        }
        MethodLocalInner inner = new MethodLocalInner();
        inner.display();
    }

    // interface used for the anonymous inner class example
    interface Greeting {
        void greet();
    }

    public static void main(String[] args) {
        // non-static inner class needs an outer instance first
        InnerClassesDemo outer = new InnerClassesDemo();
        InnerClassesDemo.InnerClass inner = outer.new InnerClass();
        inner.display(); // 10

        // static nested class, built straight off the outer class
        StaticNestedClass nested = new StaticNestedClass();
        nested.show(); // 5

        // method-local inner class
        outer.myMethod(); // Inside Method Local Inner Class

        // anonymous inner class, implemented inline, used once
        Greeting greeting = new Greeting() {
            @Override
            public void greet() {
                System.out.println("Hello from Anonymous Inner Class!");
            }
        };
        greeting.greet(); // Hello from Anonymous Inner Class!
    }
}
