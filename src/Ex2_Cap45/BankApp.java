package Ex2_Cap45;

public class BankApp {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("RO001", "Daniela", 3500);
        BankAccount a2 = new BankAccount("RO002ING", "Alex", 200);
        BankAccount a3 = new BankAccount("RO03BCR", "Maria", 0);

        a1.information();
        a2.information();
        a3.information();

        a1.deposit(500);
        a2.deposit(500);
        a3.deposit(500);

        a1.withdraw(100);
        a2.withdraw(1000);
        a3.withdraw(50);

        a1.information();
        a2.information();
        a3.information();

    }
}
