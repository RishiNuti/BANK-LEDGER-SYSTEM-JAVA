import java.util.Scanner;

public class PersonalBankLedger2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 0.0;
        double amount;
        int choice;

        System.out.println("===== PERSONAL BANK LEDGER =====");

        do {
            System.out.println("\n1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    amount = sc.nextDouble();

                    if (amount > 0) {
                        balance = balance + amount;
                        System.out.printf(
                            "Amount deposited: Rs. %.2f%n", amount);
                        System.out.printf(
                            "Current balance: Rs. %.2f%n", balance);
                    } else {
                        System.out.println("Invalid amount!");
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    amount = sc.nextDouble();

                    if (amount > 0 && amount <= balance) {
                        balance = balance - amount;
                        System.out.printf(
                            "Amount withdrawn: Rs. %.2f%n", amount);
                        System.out.printf(
                            "Current balance: Rs. %.2f%n", balance);
                    } else {
                        System.out.println(
                            "Invalid amount or insufficient balance!");
                    }
                    break;

                case 3:
                    System.out.printf(
                        "Available balance: Rs. %.2f%n", balance);
                    break;

                case 4:
                    System.out.println("Thank you for using our system!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
        sc.close();
    }
}
