class Conditionals {
    public static void main(String[] args) {

        // if else - age exercise
        int age = 10;

        if (age >= 65) {
            System.out.println("You get your income from your pension");
        } else if (age < 65 && age >= 18) {
            System.out.println("Each month you get a salary");
        } else if (age < 18) {
            System.out.println("You get an allowance");
        } else {
            System.out.println("The value of the age variable is not numerical");
        }

    }
}