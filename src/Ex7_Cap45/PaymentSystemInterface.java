package Ex7_Cap45;

interface Payable{
    void pay(double amount);
}

interface Refundable{
    void refund(double amount);
}

class CreditCard implements Payable,Refundable{
    @Override
    public void pay(double amount) {
        System.out.println("Payed the following amount: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refounded the following amount: " + amount);
    }
}

class PayPal implements Payable,Refundable{
    @Override
    public void pay(double amount) {
        System.out.println("Payed via PayPal the following amount: " + amount);
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refounded via PayPal the following amount: " + amount);
    }
}

class Crypto implements Payable{
    @Override
    public void pay(double amount) {
        System.out.println("Payed with cryptocurrency the following amount: " + amount);
    }

}

public class PaymentSystemInterface {
    static void processPayment(Payable p, double amount){
        p.pay(amount);
    }

    public static void main(String[] args) {
        Payable card = new CreditCard();
        Payable paypal = new PayPal();
        Payable crypto = new Crypto();

        processPayment(card, 200.0);
        processPayment(paypal, 70.3);
        processPayment(crypto, 27.0);

        System.out.println();

        Refundable ref = new PayPal();
        ref.refund(300.0);
    }

}
