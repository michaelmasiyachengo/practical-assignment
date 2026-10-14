public class savingsaccount extends account {
    private final double minimumBalance;
    private final double interestRate; // e.g., 0.05 for 5%

    public savingsaccount(String accountNumber, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal REJECTED for Savings " + accountNumber + 
                               ": Cannot go below minimum balance of $" + minimumBalance);
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew ($" + amount + ") from Savings " + accountNumber + ". New Balance: $" + balance);
        return true;
    }

    @Override
    public void endOfMonth() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Savings " + accountNumber + ": Applied interest of $" + interest + ". New Balance: $" + balance);
    }
}