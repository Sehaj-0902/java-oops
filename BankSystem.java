import java.util.ArrayList;

// Abstract Class
abstract class BankAccount {
    // Class fields
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Method to get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to get holder name
    public String getHolderName() {
        return holderName;
    }

    // Method to get balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit amount
    public double depositAmount(double amount) {
        balance += amount;
        return balance;
    }

    // Method to withdraw amount
    public double withdrawAmount(double amount) {
        if (balance >= amount) {
            balance -= amount;
        }
        else {
            System.out.println("Insufficient balance.");
        }
        return balance;
    }

    // Abstract method to calculate interest
    abstract double calculateInterest();

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Holder Name: " + getHolderName());
        System.out.println("Balance: " + getBalance());
        System.out.println("Balance after deposit: " +  depositAmount(250));
        System.out.println("Balance after withdrawal: " + withdrawAmount(500));
        System.out.println("Interest: " + calculateInterest());
    }
}

// Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Subclass
class SavingsAccount extends BankAccount implements Loanable {
    // Class fields
    private double interestRate;

    // Subclass constructor
    public SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        // Calling superclass constructor
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    @Override
    public double calculateInterest() {
        return getBalance() * interestRate / 100;
    }

    // Method to apply for loan
    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan amount for Savings Account: " + amount);
    }

    // Method check loan eligibility
    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 1000;
    }
}

// Subclass
class CurrentAccount extends BankAccount implements Loanable {
    // Class fields
    private double overdraftLimit = 500;
    private double interestRate;

    // Subclass constructor
    public CurrentAccount(String accountNumber, String holderName, double balance, double interestRate) {
        // Calling superclass constructor
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    // Method to calculate interest
    @Override
    public double calculateInterest() {
        return overdraftLimit * interestRate;
    }

    // Method to apply for loan
    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan amount for Current Account: " + amount);
    }

    // Method check loan eligibility
    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 1000;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();

        SavingsAccount account1 = new SavingsAccount("AC00001296", "Sehaj", 10000, 1.5);
        accounts.add(account1);

        CurrentAccount account2 = new CurrentAccount("CA00001234", "Alice", 5000, 0);
        accounts.add(account2);

        SavingsAccount account3 = new SavingsAccount("AC00001266", "Sanya", 15000, 1.5);
        accounts.add(account3);

        for (BankAccount account : accounts) {
            account.displayAccountDetails();
            if(account instanceof Loanable){
                Loanable loanAccount = (Loanable) account;
                System.out.println("Loan eligibility: " + (loanAccount.calculateLoanEligibility() ? "Eligible" : "Not Eligible"));
                loanAccount.applyForLoan(1000);
            }
            System.out.println();
        }
    }
}

/*
Output:
    Account Number: AC00001296
    Holder Name: Sehaj
    Balance: 10000.0
    Balance after deposit: 10250.0
    Balance after withdrawal: 9750.0
    Interest: 146.25
    Loan eligibility: Eligible
    Loan amount for Savings Account: 1000.0

        Account Number: CA00001234
    Holder Name: Alice
    Balance: 5000.0
    Balance after deposit: 5250.0
    Balance after withdrawal: 4750.0
    Interest: 0.0
    Loan eligibility: Eligible
    Loan amount for Current Account: 1000.0

    Account Number: AC00001266
    Holder Name: Sanya
    Balance: 15000.0
    Balance after deposit: 15250.0
    Balance after withdrawal: 14750.0
    Interest: 221.25
    Loan eligibility: Eligible
    Loan amount for Savings Account: 1000.0
 */