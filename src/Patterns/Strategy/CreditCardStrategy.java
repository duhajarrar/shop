package Patterns.Strategy;

public class CreditCardStrategy implements PaymentStrategy {

    public CreditCardStrategy() {
    
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card Number(123456789).");
        return true;
    }
    
}
