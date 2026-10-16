import java.util.Scanner;

public class PersonalBankLedger3 {

    static double deposit(double balance, double amount) {
        return balance + amount;
    }

    static double deposit(double balance, double amount, int fee) {
        return balance + amount - fee;
    }

    static double withdraw(double balance, double amount) {
        return balance - amount;
    }

    static double total(double[] transactions, int n) {
        if (n == 0)
            return 0;

        return transactions[n - 1] + total(transactions, n - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 5000;
        double[] transactions = new double[3];

        System.out.print("Enter deposit amount: ");
        transactions[0] = sc.nextDouble();
        balance = deposit(balance, transactions[0]);

        System.out.print("Enter withdrawal amount: ");
        transactions[1] = sc.nextDouble();
        balance = withdraw(balance, transactions[1]);

        System.out.print("Enter another deposit amount: ");
        transactions[2] = sc.nextDouble();
        balance = deposit(balance, transactions[2]);

        System.out.println("\n--- Personal Bank Ledger ---");
        System.out.printf("Final Balance: Rs. %.2f%n", balance);

        System.out.printf("Net Transactions: Rs. %.2f%n",
                total(transactions, transactions.length));

        System.out.println("Transaction Details:");
        for (double t : transactions) {
            System.out.println(t);
        }

        sc.close();
    }
}