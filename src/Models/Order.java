package Models;
import java.util.ArrayList;
import java.util.List;

import Patterns.Observer.OrderObserver;
import Patterns.State.OrderState;
import Patterns.State.PlacedState;

public class Order{
    private String orderDetails;
    private OrderState state;
    private List<OrderObserver> orderObservers;
    

    public Order(String orderDetails) {
        this.orderDetails = orderDetails;
        // used for State pattern
        this.state = new PlacedState();
        this.orderObservers = new ArrayList<>();
    }
    
    // used for Observer pattern
    public void addObserver(OrderObserver observer) {
        orderObservers.add(observer);
    }
    
    // used for Observer pattern
    public void removeObserver(OrderObserver observer) {
        orderObservers.remove(observer);
    }

    // used for Observer pattern
    private void notifyObservers() {
        for (OrderObserver observer : orderObservers) {
            observer.update(this);
        }
    }

    public void setState(OrderState state) {
        this.state = state;
        this.state.printStatus();
        notifyObservers();
    }

    // used for state pattern
    public void nextStage() {
        this.state.next(this);
        notifyObservers();
    }

    // used for state pattern
    public void previousStage() {
        this.state.prev(this);
        notifyObservers();
    }

    // used for state pattern
    public void printStatus() {
        state.printStatus();
    }

    // used for state pattern
    public OrderState getState() {
        return state;
    }
    
    // used for command pattern
    public void place() {
        if (this.getState() instanceof PlacedState) {
            System.out.println("Order placed: " + this.toString());
            this.setState(new PlacedState());
            notifyObservers();
        } else {
            System.out.println("Order has already been placed.");
        }
    }
    // used for command pattern
    public void modify(String newDetails) {
        if (this.getState() instanceof PlacedState) {
            this.orderDetails = newDetails;
            notifyObservers();
            System.out.println("Order modified: " + orderDetails);
        } else {
            System.out.println("Cannot modify. Order has not been placed.");
        }   
    }

    // used for command pattern
    public void cancel() {
        if (this.getState() instanceof PlacedState) {
            System.out.println("Order canceled: " + orderDetails);
            this.setState(null);
            notifyObservers();
        } else {
            System.out.println("Cannot cancel. Order has not been placed.");
        }
    }

    @Override
    public String toString() {
        return "Order [orderDetails=" + orderDetails + ", state=" + state
                + ", orderObservers=" + orderObservers + "]";
    }
}
