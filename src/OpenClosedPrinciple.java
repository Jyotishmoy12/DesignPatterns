
// Open for Extension: This means the behavior of the entity can be extended. 
// As new requirements come in (like new payment types), you should be able to add new behavior.
// Closed for Modification: This means the existing, 
// working code of the entity should not be changed. 
// Once it's written, tested, and working, you shouldn't need to go back and alter it to add new features.

interface PaymentMethod {
    void processPayment(double amount);
}

// Now, for each payment type, we create a separate class that implements this
// interface:

class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Process credit card payment
        System.out.println("Processing credit card payment of $" + amount);
    }
}

class PayPalPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Process PayPal payment
        System.out.println("Processing PayPal payment of $" + amount);
    }
}

class UPIPayment implements PaymentMethod {
    @Override
    public void processPayment(double amount) {
        // Process UPI payment
        System.out.println("Processing UPI payment of $" + amount);
    }
}

class PaymentProcessor {
    public void process(PaymentMethod paymentMethod, double amount) {
        paymentMethod.processPayment(amount);
    }
}

class CheckoutService {
    public void processPayment(PaymentMethod paymentMethod, double amount) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        paymentProcessor.process(paymentMethod, amount);
    }
}

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        CheckoutService checkoutService = new CheckoutService();
        checkoutService.processPayment(new CreditCardPayment(), 100.0);
        checkoutService.processPayment(new PayPalPayment(), 50.0);
        checkoutService.processPayment(new UPIPayment(), 75.0);
    }
}
