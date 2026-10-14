public class currentaccount extends account {
  private final double overdraftLimit;
    private final double monthlyFee;
    
    public currentaccount(String accountNumber, double balance, double overdraftLimit, double monthlyFee) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount < -overdraftLimit) {
            System.out.println("Withdrawal REJECTED for Current " + accountNumber + 
                               ": Exceeds overdraft limit of $" + overdraftLimit);
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew $" + amount + " from Current " + accountNumber + ". New Balance: $" + balance);
        return true;
    }

    @Override
    public void endOfMonth() {
        balance -= monthlyFee;
        System.out.println("Current " + accountNumber + ": Deducted maintenance fee of $" + monthlyFee + ". New Balance: $" + balance);
    }
}