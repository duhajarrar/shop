package Patterns.Decorator;
import Models.Item;

public class PercentageDiscountDecorator extends ItemDecorator {
    private double discountPercentage;

    public PercentageDiscountDecorator(Item item, double discountPercentage) {
        super(item);
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        return super.getPrice() * (1 - discountPercentage / 100.0);
    }

    @Override
    public String toString() {
        return super.toString() + " (Discounted " + discountPercentage + "%)";
    }
}

