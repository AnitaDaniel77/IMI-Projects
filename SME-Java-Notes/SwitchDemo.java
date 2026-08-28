public class SwitchDemo {
    public static void main(String[] args) {

        int day = 3;
        String dayName;

        // switch picks a path from a list of exact values
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            default:
                dayName = "Unknown";
        }

        System.out.println("day " + day + " -> " + dayName);
    }
}