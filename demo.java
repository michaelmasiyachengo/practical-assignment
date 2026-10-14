import java.util.ArrayList;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        // Create polymorphic list of accounts
        List<account> accounts = new ArrayList<>();

        savingsaccount sa = new savingsaccount("SA101", 500.0, 100.0, 0.05); // $100 min balance, 5% interest
        currentaccount ca = new currentaccount("CA202", 200.0, 300.0, 15.0); // $300 overdraft, $15 fee

        accounts.add(sa);
        accounts.add(ca);

        System.out.println("=== DEMONSTRATING EDGE CASES ===");
        // 1. SavingsAccount withdrawal rejection (Attempting to leave balance < $100)
        System.out.println("\n-- Test 1: Savings Account Minimum Balance Edge Case --");
        sa.withdraw(450.0); // 500 - 450 = 50 (< 100 min), should be rejected

        // 2. CurrentAccount overdraft within limit (Going negative but >= -$300)
        System.out.println("\n-- Test 2: Current Account Overdraft Edge Case --");
        ca.withdraw(350.0); // 200 - 350 = -150 (within -$300 limit), should succeed

        System.out.println("\n=== POLYMORPHIC LOOP (END OF MONTH) ===");
        // Calling withdraw and endOfMonth through account reference only
        for (account acc : accounts) {
            acc.withdraw(20.0);   // Runs overridden withdraw
            acc.endOfMonth();     // Runs overridden endOfMonth
            System.out.println("Final Balance for " + acc.getAccountNumber() + ": $" + acc.getBalance());
            System.out.println("-----------------------------------");
        }
    }
}