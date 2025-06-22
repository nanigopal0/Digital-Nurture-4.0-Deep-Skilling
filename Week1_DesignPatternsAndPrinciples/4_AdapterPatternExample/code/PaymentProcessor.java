

public interface PaymentProcessor {
    boolean processPayment(String cardNumber, int cvv, int amount);

    boolean processPayment(String upi, int amount);
}
