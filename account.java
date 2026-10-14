public abstract class account {
    protected String accountNumber;
    protected double balance;

    public account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
           System.out.println("Deposited (" + amount + " into " + accountNumber + ". New Balance:)" + balance);
        } else {
            System.out.println("Deposit rejected: Amount must be positive.");
        }
    }

    // Abstract methods to be implemented by subclasses
    public abstract boolean withdraw(double amount);
    public abstract void endOfMonth();
}