package Patterns.Strategy;

public class BitcoinStrategy implements PaymentStrategy {

    

    public BitcoinStrategy() {
        
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Paid " + amount + " using Bitcoin(wallet).");
        return true;
    }
}
