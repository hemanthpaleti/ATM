package atm;
import java.util.Scanner;

public class ATM {
    private User user;
    private Account account;
    private Scanner scanner;

    // Constructor for ATM
    public ATM(User user, Account account) {
        this.user = user;
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Login Method
    private boolean login() {
        System.out.println("Enter your username:");
        String inputUsername = scanner.nextLine();

        if (!inputUsername.equals(user.getUsername())) {
            System.out.println("Invalid username.");
            return false;
        }

        // Password validation
        System.out.println("Enter your password:");
        String inputPassword = scanner.nextLine();
        
        if (user.validatePassword(inputPassword)) {
            System.out.println("Login successful!");
            return true;
        } else {
            System.out.println("Incorrect password.");
            return false;
        }
    }

    // Main operations
    public void start() {
        if (!login()) {
            System.out.println("Login failed. Exiting.");
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option: ");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. View Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Calculate Interest");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    depositMoney();
                    break;
                case 2:
                    withdrawMoney();
                    break;
                case 3:
                    viewBalance();
                    break;
                case 4:
                    account.viewTransactions();
                    break;
                case 5:
                    calculateInterest();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }

    // Deposit money method
    private void depositMoney() {
        System.out.print("Enter deposit amount: ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            account.deposit(depositAmount);
            System.out.println("Amount deposited.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw money method
    private void withdrawMoney() {
        System.out.print("Enter withdraw amount: ");
        double withdrawAmount = scanner.nextDouble();
        if (withdrawAmount > 0) {
            if (account.withdraw(withdrawAmount)) {
                System.out.println("Amount withdrawn.");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Invalid withdraw amount.");
        }
    }

    // View balance method
    private void viewBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    // Calculate interest method
    private void calculateInterest() {
        System.out.print("Enter interest rate (%): ");
        double rate = scanner.nextDouble();
        if (rate > 0) {
            System.out.println("Interest: " + account.calculateInterest(rate));
        } else {
            System.out.println("Invalid interest rate.");
        }
    }
}

