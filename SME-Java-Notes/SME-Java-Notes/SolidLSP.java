// Liskov Substitution Principle: a subtype must be safely usable wherever the parent type is expected
public class SolidLSP {
    public static void main(String[] args) {
        // BEFORE - looks fine, breaks
        BrokenRectangle rect = new BrokenSquare();
        rect.setWidth(5);
        rect.setHeight(4);
        System.out.println("broken area (expected 20): " + rect.area());
        // often prints 16, the square forced both sides to 4, the caller's instructions got overwritten

        // AFTER - safe substitution
        printArea(new SafeRectangle(5, 4)); // 20
        printArea(new SafeSquare(4));       // 16, and that's honestly what was asked for
    }

    static void printArea(Shape shape) {
        System.out.println(shape.area());
    }
}

class BrokenRectangle {
    int width, height;

    void setWidth(int width) {
        this.width = width;
    }

    void setHeight(int height) {
        this.height = height;
    }

    int area() {
        return width * height;
    }
}

class BrokenSquare extends BrokenRectangle {
    @Override
    void setWidth(int width) {
        this.width = width;
        this.height = width; // secretly changes height too
    }

    @Override
    void setHeight(int height) {
        this.width = height; // secretly changes width too
        this.height = height;
    }
}

interface Shape {
    int area();
}

class SafeRectangle implements Shape {
    private final int width;
    private final int height;

    SafeRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int area() {
        return width * height;
    }
}

class SafeSquare implements Shape {
    private final int side;

    SafeSquare(int side) {
        this.side = side;
    }

    public int area() {
        return side * side;
    }
}
