package adapter;

// You’re integrating with a legacy system or a third-party library that doesn’t match your current interface.
//You need to bridge the gap between new and old code, or between systems built with different interface designs.

// When faced with incompatible interfaces, developers often resort to rewriting 
// large parts of code or embedding conditionals 
// like if (legacyType) to handle special cases. 
// For example, a PaymentProcessor might use if-else logic
//  to handle both a modern StripeService and a legacy BankTransferAPI.

// The Adapter Pattern solves this by introducing a wrapper class that 
//  between your system and the incompatible component. It translates 
// calls from your interface into calls the legacy or third-party system understands 
//  without changing either side.

// Bad example of the Adapter Pattern

// suppose Imagine you’re building the checkout component of an e-commerce application.
//Your Checkout Service is designed to work with a Payment Interface for handling payments.

interface PaymentProcessor {
    void processPayment(double amount, String currency);

    boolean isPaymentSuccessful();

    String getTransactionId();
}

// I already have a internal payment processor that fits this interface

class InHousePaymentProcessor implements PaymentProcessor {
    private String transactionId;
    private boolean isPaymentSuccessful;

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("InHousePaymentProcessor: Processing payment of " + amount + " " + currency);
        transactionId = "TXN_" + System.currentTimeMillis();
        isPaymentSuccessful = true;
        System.out.println("InHousePaymentProcessor: Payment successful. Txn ID: " + transactionId);
    }

    @Override
    public boolean isPaymentSuccessful() {
        return isPaymentSuccessful;
    }

    @Override
    public String getTransactionId() {
        return transactionId;
    }
}

class CheckoutService {
    private PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount, String currency) {
        System.out.println("CheckoutService: Attempting to process order for $" + amount + " " + currency);
        paymentProcessor.processPayment(amount, currency);
        if (paymentProcessor.isPaymentSuccessful()) {
            System.out.println("CheckoutService: Order successful! Transaction ID: "
                    + paymentProcessor.getTransactionId());
        } else {
            System.out.println("CheckoutService: Order failed. Payment was not successful.");
        }
    }
}

public class ECommerceAppV1 {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new InHousePaymentProcessor();
        CheckoutService checkoutService = new CheckoutService(paymentProcessor);
        checkoutService.checkout(100.0, "USD");
    }
}

// now suppose you have a new payment processor that doesn't fit this interface
// you need to rewrite a lot of code or embed conditionals
// to handle both a modern StripeService and a legacy BankTransferAPI

// our checkout service expects PaymentProcessor interface
// but legacyGateway has a different interface
// heres the challenge we cant change the CheckoutService code
// And cant change the LegacyGateway code either
// so we need to use the Adapter Pattern
class LegacyGateway {
    private long transactionReference;
    private boolean isPaymentSuccessful;

    public void executeTransaction(double totalAmount, String currency) {
        System.out.println("LegacyGateway: Executing transaction for "
                + currency + " " + totalAmount);
        transactionReference = System.nanoTime();
        isPaymentSuccessful = true;
        System.out.println("LegacyGateway: Transaction executed successfully. Txn ID: "
                + transactionReference);
    }

    public boolean checkStatus(long transactionReference) {
        System.out.println("LegacyGateway: Checking status for ref: " + transactionReference);
        return isPaymentSuccessful;
    }

    public long getReferenceNumber() {
        return transactionReference;
    }
}

// The Adapter acts as a bridge between an incompatible interface and what the
// client actually expects.
// It provides a new interface that the client can use to interact with the
// incompatible system.

// twp types of adapters
// 1. Object Adapter -- preferable
// -- Uses composition: the adapter holds a reference to the adaptee (the object
// it wraps).
// Allows flexibility and reuse across class hierarchies.
// This is the most common and recommended approach in Java.

// 2. Class Adapter -- rare to use

// Real-World Analogy
// Imagine you're traveling from the United States to Europe. Your laptop
// charger uses a Type A plug (used in the US), but European wall sockets expect
// a Type C plug.

// You can’t plug your charger in directly—the interfaces don’t match.

// Instead of buying a new charger, you use a travel plug adapter. This device
// accepts your Type A plug and converts it into a Type C shape that fits into
// the European socket.

// You don’t modify the wall socket (it’s like the third-party API).
// You don’t modify your charger (it’s like your existing business logic).
// The adapter sits in between and translates the connection.
// For our example:

// Charger → your application (CheckoutService)
// Wall socket → third-party system (LegacyGateway)
// Travel plug adapter → Adapter class (LegacyGatewayAdapter)

// the adapter class

class LegacyGatewayAdapter implements PaymentProcessor {
    private final LegacyGateway legacyGateway;
    private long currentRef;

    public LegacyGatewayAdapter(LegacyGateway legacyGateway) {
        this.legacyGateway = legacyGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        System.out.println("Adapter: Processing payment for $" + amount + " " + currency);
        legacyGateway.executeTransaction(amount, currency);
        currentRef = legacyGateway.getReferenceNumber();
    }

    @Override
    public boolean isPaymentSuccessful() {
        return legacyGateway.checkStatus(currentRef);
    }

    @Override
    public String getTransactionId() {
        return String.valueOf(currentRef);
    }
}