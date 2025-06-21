

public class PaymentAdapter implements PaymentProcessor{
    private final Razorpay razorpay ;
    private final Stripe stripe;

    public PaymentAdapter(Razorpay razorpay, Stripe stripe){
        this.razorpay = razorpay;
        this.stripe = stripe;
    }

    @Override
    public boolean processPayment(String cardNumber,int cvv, int amount) {
        return stripe.payWithCard(cardNumber, cvv, amount);
    }

    @Override
    public boolean processPayment(String upi,int amount) {
        return razorpay.payWithUpi(upi, amount);
    }
}
