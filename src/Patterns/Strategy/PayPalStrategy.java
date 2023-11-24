package Patterns.Strategy;

public class PayPalStrategy implements PaymentStrategy {


    public PayPalStrategy() {
        
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using using PayPal account(email).");
        return true;
    }
    
}
