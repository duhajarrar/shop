package Patterns.ChainOfResponsibility;

import Models.Item;

public class QuantityDiscountHandler extends DiscountHandler {
    private double discountQuantity;

    public QuantityDiscountHandler(double discountQuantity) {
        this.discountQuantity = discountQuantity;
    }

    @Override
    public double applyDiscount(Item item) {
        double discountedPrice = item.getPrice() - discountQuantity;
        System.out.println("Applied " + discountQuantity + " discount.");
        return discountedPrice;
    }
}