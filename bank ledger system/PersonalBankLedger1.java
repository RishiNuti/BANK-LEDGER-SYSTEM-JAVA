import java.util.Scanner;

public class PersonalBankLedger1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String BANK_NAME = "Personal Bank";

        double balance = 5000.0;
        double deposit, withdrawal;
        double finalBalance;

        System.out.println("===== " + BANK_NAME + " =====");

        System.out.printf("Opening Balance: Rs. %.2f%n", balance);

        System.out.print("Enter deposit amount: ");
        deposit = sc.nextDouble();

        System.out.print("Enter withdrawal amount: ");
        withdrawal = sc.nextDouble();

        finalBalance = balance + deposit - withdrawal;

        System.out.printf("Deposit Amount: Rs. %.2f%n", deposit);
        System.out.printf("Withdrawal Amount: Rs. %.2f%n", withdrawal);
        System.out.printf("Final Balance: Rs. %.2f%n", finalBalance);

        sc.close();
    }
}