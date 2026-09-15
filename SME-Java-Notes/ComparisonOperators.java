public class ComparisonOperators {
    public static void main(String[] args) {

        int age = 20;
        int passingMark = 50;
        int score = 72;

        // comparisons produce a boolean; they do NOT change the values
        System.out.println("age == 20: " + (age == 20));           // true, equal to
        System.out.println("age != 20: " + (age != 20));           // false, not equal to
        System.out.println("score > passingMark: " + (score > passingMark));  // true
        System.out.println("score < passingMark: " + (score < passingMark));  // false
        System.out.println("score >= 72: " + (score >= 72));       // true, greater than or equal
        System.out.println("age <= 18: " + (age <= 18));           // false, less than or equal
    }
}