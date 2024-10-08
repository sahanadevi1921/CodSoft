import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
public class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Amount withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Amount deposited: " + amount);
    }

    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    public void displayOptions() {
        System.out.println("\nATM Options:");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(1000); 
        ATM atm = new ATM(bankAccount);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you!!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }
}
