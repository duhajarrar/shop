package Patterns.Command;

import Models.*;

public class ModifyOrderCommand implements OrderCommand {
    private Order order;
    private String newDetails;
    
    public ModifyOrderCommand(Order order, String newDetails) {
        this.order = order;
        this.newDetails = newDetails;
    }

    @Override
    public void execute() {
        order.modify(newDetails);
    }
    
}
