package Patterns.Observer;

import Models.Order;

public interface OrderObserver {
    void update(Order order);
}
