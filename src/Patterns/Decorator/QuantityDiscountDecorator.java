package Patterns.Decorator;
import Models.Item;

public class QuantityDiscountDecorator extends ItemDecorator {
    private double discountQuantity;

    public QuantityDiscountDecorator(Item item, double discountQuantity) {
        super(item);
        this.discountQuantity = discountQuantity;
    }

    @Override
    public double getPrice() {
        double discountedPrice = super.getPrice();
        if(super.getPrice() > discountQuantity)
            discountedPrice = super.getPrice() - discountQuantity;
        return discountedPrice;
    }

    @Override
    public String toString() {
        return super.toString() + " (Discounted Quantity " + discountQuantity + ")";
    }

    
}

