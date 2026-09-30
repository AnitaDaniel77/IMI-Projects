public class EmployeeManagementDemo {
    public static void main(String[] args) {
        // testing each overloaded constructor
        Employee e1 = new Employee();
        Employee e2 = new Employee("Naledi");
        Employee e3 = new Employee("Karabo", 29);
        Employee e4 = new Employee("Sipho", 34, 25000.0);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        // testing validation, invalid age should be rejected
        try {
            Employee bad = new Employee("Invalid", 200, 15000.0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught expected error: " + ex.getMessage());
        }

        // annual salary and a raise
        System.out.println(e4.getName() + " annual salary: R" + e4.calculateAnnualSalary());
        e4.giveRaise(10); // 10% raise
        System.out.println(e4.getName() + " new monthly salary after raise: R" + e4.getSalary());

        // cloning, change the clone, confirm the original is untouched
        Employee e4Clone = e4.clone();
        e4Clone.setSalary(30000.0);
        System.out.println("Original: " + e4);
        System.out.println("Clone: " + e4Clone);
    }
}