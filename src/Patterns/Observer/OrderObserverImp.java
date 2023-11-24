package Patterns.Observer;

import Models.Order;

public class OrderObserverImp implements OrderObserver{
     @Override
    public void update(Order order) {
        System.out.println("Notified: Order status changed.");
        order.printStatus();
    }
}
