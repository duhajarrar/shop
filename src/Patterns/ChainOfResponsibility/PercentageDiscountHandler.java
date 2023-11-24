package Patterns.ChainOfResponsibility;

import Models.Item;
public class PercentageDiscountHandler extends DiscountHandler {
    private double discountPercentage;

    public PercentageDiscountHandler(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double applyDiscount(Item item) {
        double discountedPrice = item.getPrice() * (1 - discountPercentage / 100.0);
        System.out.println("Applied " + discountPercentage + "% discount.");
        return discountedPrice;
    }
}