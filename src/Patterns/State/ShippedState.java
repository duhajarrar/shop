package Patterns.State;

import Models.Order;

public class ShippedState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order shipped. It cannot be moved to another state.");
    }

    @Override
    public void prev(Order order) {
        order.setState(new PaidState());
    }

    @Override
    public void printStatus() {
        System.out.println("Order shipped.");
    }
}


