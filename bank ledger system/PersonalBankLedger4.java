class BankAccount {

    private String name;
    private double balance;

    static final String BANK_NAME = "Personal Bank";

    BankAccount() {
        this("Student", 0.0);
    }

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Invalid deposit amount");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount <= 0 || amount > balance) {
            throw new Exception("Invalid withdrawal amount");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account Holder: " + name
                + "\nBalance: Rs. " + balance;
    }
}

class StudentAccount extends BankAccount {

    StudentAccount(String name, double balance) {
        super(name, balance);
    }

    @Override
    public String toString() {
        return "Student Bank Account\n" + super.toString();
    }
}

public class PersonalBankLedger4 {

    public static void main(String[] args) {

        BankAccount account = new StudentAccount("Student", 5000);

        try {
            account.deposit(2000);
            account.withdraw(1000);

            System.out.println(BankAccount.BANK_NAME);
            System.out.println(account);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            System.out.println("Transaction completed.");
        }
    }
}