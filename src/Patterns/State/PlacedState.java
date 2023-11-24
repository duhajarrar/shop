package Patterns.State;

import Models.Order;

public class PlacedState implements OrderState {
    @Override
    public void next(Order order) {
        order.setState(new PaidState());
    }

    @Override
    public void prev(Order order) {
        System.out.println("The order is in its initial state.");
    }

    @Override
    public void printStatus() {
        System.out.println("Order placed. Awaiting payment.");
    }
}
