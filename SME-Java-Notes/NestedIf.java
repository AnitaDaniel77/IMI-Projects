public class NestedIf {

    enum Level { HIGH, LOW }

    public static void main(String[] args) {

        Level level;
        int scoreLevel = 0;

        // if/else chooses among two ranges
        if (scoreLevel > 100) {
            level = Level.HIGH;
        } else {
            level = Level.LOW;
        }

        // switch on an enum works the same way as switch on an int
        switch (level) {
            case HIGH:
                break;
            case LOW:
                break;
            default:
                System.out.println("The level you entered doesn't exist");
                break;
        }
    }
}