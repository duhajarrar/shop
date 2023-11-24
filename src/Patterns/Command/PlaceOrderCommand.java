package Patterns.Command;
import Models.Order;

public class PlaceOrderCommand implements OrderCommand {
    private Order order;

    public PlaceOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.toString()+" Placed");
        order.place();
    }
    
}
