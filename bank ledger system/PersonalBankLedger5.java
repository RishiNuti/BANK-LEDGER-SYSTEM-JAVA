import java.util.*;
import java.nio.file.*;

public class PersonalBankLedger5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account holder name: ");
            String name = sc.nextLine().trim();

            System.out.print("Enter deposit amount: ");
            String d = sc.nextLine();

            System.out.print("Enter withdrawal amount: ");
            String w = sc.nextLine();

            double deposit = Double.parseDouble(d);
            double withdrawal = Double.parseDouble(w);

            double balance = 5000 + deposit - withdrawal;

            String record = name + "," + deposit + ","
                    + withdrawal + "," + balance;

            Path file = Paths.get("ledger.txt");

            Files.writeString(file, record + "\n",
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);

            System.out.println("\n--- Bank Ledger ---");
            System.out.println("Name: " + name.toUpperCase());
            System.out.println("Name length: " + name.length());
            System.out.println("Final balance: Rs. " + balance);

            System.out.println("\nSaved Records:");

            String text = Files.readString(file);
            System.out.println(text);

            String[] names = {"Ravi", "Aman", name};
            Arrays.sort(names);

            System.out.println("Sorted names: "
                    + Arrays.toString(names));

        } catch (Exception e) {
            System.out.println("Invalid input or file error.");
        }

        sc.close();
    }
}