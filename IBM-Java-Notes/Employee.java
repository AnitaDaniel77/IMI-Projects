public class Employee {
    // properties, all private: only Employee's own methods touch these directly
    private int employeeId;
    private String name;
    private String department;
    private String email;
    private int leaveBalance = 20; // annual leave balance in days, default 20

    // default constructor, sets placeholder values when no info is given
    public Employee() {
        this.employeeId = 0;
        this.name = "unknown";
        this.department = "unassigned";
        this.email = "";
    }

    // parameterized constructor, real employee details supplied
    public Employee(int employeeId, String name, String department, String email) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    // getters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public int getLeaveBalance() {
        return leaveBalance;
    }

    // setters, with validation on leaveBalance
    public void setLeaveBalance(int leaveBalance) {
        if (leaveBalance >= 0) {
            this.leaveBalance = leaveBalance;
        } else {
            System.out.println("Leave balance cannot be negative.");
        }
    }

    // works out what's left after a request, without going negative
    public int calculateRemainingLeave(int daysRequested) {
        int remaining = leaveBalance - daysRequested;
        if (remaining < 0) {
            System.out.println("Not enough leave balance available.");
            return leaveBalance;
        }
        return remaining;
    }
}