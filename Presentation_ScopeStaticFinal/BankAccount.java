public class BankAccount {

    // final: once this account number is set, it can never change
    private final String accountNumber;
    private double balance;
    

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount("CAP-10293", 500.00);
        System.out.println("Account number: " + account.accountNumber);
        System.out.println("Balance: " + account.balance);
    }
}