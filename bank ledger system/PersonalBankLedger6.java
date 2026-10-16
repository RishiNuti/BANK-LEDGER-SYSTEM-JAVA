
import java.util.*;
import java.util.stream.*;

public class PersonalBankLedger6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> transactions = new ArrayList<>();
        HashMap<String, Double> accounts = new HashMap<>();
        HashSet<String> customers = new HashSet<>();

        System.out.print("Enter customer name: ");
        String name = sc.nextLine();

        System.out.print("Enter opening balance: ");
        double balance = sc.nextDouble();

        accounts.put(name, balance);
        customers.add(name);

        System.out.print("Enter deposit amount: ");
        double deposit = sc.nextDouble();

        balance = balance + deposit;
        transactions.add("Deposit: " + deposit);

        System.out.print("Enter withdrawal amount: ");
        double withdrawal = sc.nextDouble();

        balance = balance - withdrawal;
        transactions.add("Withdrawal: -" + withdrawal);

        accounts.put(name, balance);

        System.out.println("\n--- Personal Bank Ledger ---");

        accounts.forEach((customer, amount) ->
            System.out.println(customer + " Balance: Rs. " + amount)
        );

        System.out.println("\nTransactions:");
        transactions.forEach(System.out::println);

        long count = transactions.stream().count();
        System.out.println("Total transactions: " + count);

        List<String> sortedTransactions = transactions.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nSorted Transactions:");
        sortedTransactions.forEach(System.out::println);

        System.out.println("\nUnique Customers:");
        customers.forEach(System.out::println);

        double total = transactions.stream()
                .map(t -> Double.parseDouble(t.split(": ")[1]))
                .reduce(0.0, (a, b) -> a + b);

        System.out.println("Net transaction amount: Rs. " + total);
        sc.close();
    }
}
