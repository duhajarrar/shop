package Patterns.State;

import Models.Order;

public interface OrderState {
    void next(Order order);
    void prev(Order order);
    void printStatus();
}

