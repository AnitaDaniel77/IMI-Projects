import java.util.Scanner;

public class SimpleInterest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // ask for the three inputs
        System.out.println("Enter the principal:");
        double p = in.nextDouble();
        System.out.println("Enter time period in years:");
        double t = in.nextDouble();
        System.out.println("Enter rate of interest per year:");
        double r = in.nextDouble();

        // same formula as the bash script
        double interest = p * t * r / 100;
        System.out.printf("The simple interest is: %.2f%n", interest);
    }
}