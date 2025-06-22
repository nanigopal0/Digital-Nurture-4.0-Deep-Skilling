

public class Test {
    public static void main(String[] args) {

        PaymentProcessor paymentProcessor = new PaymentAdapter(new Razorpay(), new Stripe());
        boolean paid = paymentProcessor.processPayment("123ABC", 432, 500);
        if (paid) System.out.println("Payment successful");
        else System.out.println("Payment failed");
        paid = paymentProcessor.processPayment("myupi@bank.in", 100);
        if (paid) System.out.println("Payment successful");
        else System.out.println("Payment failed");
    }
}
