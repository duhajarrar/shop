package Patterns.ChainOfResponsibility;

import Models.Item;

public abstract class DiscountHandler {
    protected DiscountHandler nextHandler;

    public void setNextHandler(DiscountHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract double applyDiscount(Item item);

    public double processDiscount(Item item) {
        double discountedPrice = applyDiscount(item);

        if (nextHandler != null) {
            return nextHandler.processDiscount(item);
        }

        return discountedPrice;
    }
}

