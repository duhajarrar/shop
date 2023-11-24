package Patterns.State;

import Models.Order;

public class PaidState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new ShippedState());
    }

    @Override
    public void prev(Order order) {
        order.setState(new PlacedState());
    }

    @Override
    public void printStatus() {
        
        System.out.println("Order paid. Awaiting shipment.");
    }
}

