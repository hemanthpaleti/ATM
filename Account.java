package atm;

import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<String> transactions;

    // Constructor
    public Account() {
        balance = 0;
        transactions = new ArrayList<>();
    }

    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount);
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount);
            return true;
        } else {
            return false; // Insufficient balance
        }
    }

    // View balance
    public double getBalance() {
        return balance;
    }

    // View transaction history
    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions available.");
        } else {
            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    // Calculate interest (simple interest for demonstration)
    public double calculateInterest(double interestRate) {
        return balance * interestRate / 100;
    }
}

