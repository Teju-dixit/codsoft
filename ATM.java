import java.util.Scanner;

public class ATM {
    private double balance;
    private Scanner scanner;

    // Constructor
    public ATM() {
        this.balance = 0.0; // Initial balance
        this.scanner = new Scanner(System.in);
    }

    // Main menu
    public void showMenu() {
        int choice;
        do {
            System.out.println("\n=== ATM Interface ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

    // Check balance
    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    // Deposit money
    private void depositMoney() {
        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Withdraw money
    private void withdrawMoney() {
        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Successfully withdrew $" + amount);
                checkBalance();
            } else {
                System.out.println("Insufficient balance. Transaction failed.");
            }
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    // Main method
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.showMenu();
    }
}