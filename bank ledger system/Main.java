import java.util.*;
import java.nio.file.*;
import java.io.IOException;
import java.util.stream.*;

public class Main {

    private String name;
    private double balance;

    Main(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public String toString() {
        return name + " Balance: Rs. " + balance;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> transactions = new ArrayList<>();
        HashMap<String, Main> accounts = new HashMap<>();
        HashSet<String> customers = new HashSet<>();

        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter opening balance: ");
            double opening = Double.parseDouble(sc.nextLine());

            Main account = new Main(name, opening);

            accounts.put(name, account);
            customers.add(name);

            System.out.print("Enter deposit: ");
            double deposit = Double.parseDouble(sc.nextLine());

            if (deposit > 0) {
                account.deposit(deposit);
                transactions.add("Deposit: " + deposit);
            } else {
                System.out.println("Invalid deposit!");
            }

            System.out.print("Enter withdrawal: ");
            double withdrawal = Double.parseDouble(sc.nextLine());

            if (withdrawal > 0 &&
                    withdrawal <= account.getBalance()) {
                account.withdraw(withdrawal);
                transactions.add("Withdrawal: " + withdrawal);
            } else {
                System.out.println("Invalid withdrawal!");
            }

            System.out.println("\n--- Bank Ledger ---");
            System.out.println(accounts.get(name));

            System.out.println("\nTransaction History:");
            transactions.forEach(System.out::println);

            long count = transactions.stream().count();
            System.out.println("Total transactions: " + count);

            List<String> sorted = transactions.stream()
                    .sorted()
                    .collect(Collectors.toList());

            System.out.println("\nSorted Transactions:");
            sorted.forEach(System.out::println);

            System.out.println("\nCustomers:");
            customers.forEach(System.out::println);

            try {
                Path file = Paths.get("ledger.txt");

                Files.write(file, transactions,
                        StandardOpenOption.CREATE,
                        StandardOpenOption.APPEND);

                System.out.println("Ledger saved successfully!");

            } catch (IOException e) {
                System.out.println(
                        "File saving is not supported in this environment.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numbers.");
        } finally {
            sc.close();
        }
    }
}