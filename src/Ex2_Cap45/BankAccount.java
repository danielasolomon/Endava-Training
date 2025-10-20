package Ex2_Cap45;

public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;

    public BankAccount(String accountNumber, String owner, double balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if(accountNumber == null || accountNumber.isBlank()) {
            System.out.println("Account number cannot be null or blank");
            return;
        }
        this.accountNumber = accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if(owner == null || owner.isBlank()) {
            System.out.println("Owner cannot be null or blank");
            return;
        }
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(balance < 0) {
            System.out.println("Balance cannot be negative -> setting to 0");
            this.balance = 0;
        }else{
            this.balance = balance;
        }
    }

    public void deposit(double amount) {
        if(amount < 0) {
            System.out.println("Amount must be > 0");
            return;
        }

        this.balance += amount;
        System.out.printf("Deposited %.2f. New balance %.2f%n", amount, balance);
    }

    public void withdraw(double amount) {
        if(amount < 0) {
            System.out.println("Amount must be > 0");
            return;
        }

        if(amount > balance) {
            System.out.printf("Withdraw %.2f. insuficent founds\n", amount);
            return;
        }

        this.balance -= amount;
        System.out.printf("Withdraw %.2f. New balance %.2f%n", amount, balance);
    }

    public void information() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + owner);
        System.out.println("Balance: " + balance + "\n");
    }
}
