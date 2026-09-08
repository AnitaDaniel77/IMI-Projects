public class LambdaExpressions {

    // functional interface: exactly one method, taking no params, returning nothing
    interface Executable {
        void execute();
    }

    // functional interface with a return value
    interface ExecutableWithReturn {
        int execute();
    }

    // functional interface with a parameter and a return value
    interface ExecutableWithParam {
        int execute(int a);
    }

    // class that accepts a block of code and runs it
    static class Runner {
        public void run(Executable e) {
            System.out.println("executing code block...");
            e.execute(); // calls whatever code was passed in
        }

        public int runWithReturn(ExecutableWithReturn e) {
            return e.execute();
        }

        public int runWithParam(ExecutableWithParam e, int value) {
            return e.execute(value);
        }
    }

    public static void main(String[] args) {

        Runner runner = new Runner();

        // OLD WAY (pre-Java 8): anonymous class implementing the interface
        runner.run(new Executable() {
            @Override
            public void execute() {
                System.out.println("Hello there (old anonymous class syntax)");
            }
        });

        // NEW WAY: lambda expression — same result, far less code
        runner.run(() -> System.out.println("Hello there (lambda)"));

        // lambda with a code block (multiple statements) instead of one expression
        runner.run(() -> {
            System.out.println("Line 1 of the lambda block");
            System.out.println("Line 2 of the lambda block");
        });

        // lambda returning a value — no need to declare the return type, Java infers it
        int result = runner.runWithReturn(() -> 8);
        System.out.println("Return value is " + result);

        // lambda with a parameter — type is inferred, no need to write "int a"
        int sum = runner.runWithParam(a -> a + 7, 12);
        System.out.println("Sum result: " + sum);

        // using a variable from the enclosing method inside the lambda
        // this only works because otherValue is "effectively final" (assigned once, never changed)
        int otherValue = 100;
        runner.run(() -> System.out.println("Using outer variable: " + otherValue));
    }
}