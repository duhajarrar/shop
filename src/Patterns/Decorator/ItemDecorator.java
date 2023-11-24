package Patterns.Decorator;
import Models.Item;
public abstract class ItemDecorator extends Item {
    protected Item decoratedItem;

    public ItemDecorator(Item decoratedItem) {
        super(decoratedItem.getItemName(), decoratedItem.getStoreId(), decoratedItem.getPrice());
        this.decoratedItem = decoratedItem;
    }

    public String toString() {
        return decoratedItem.toString();
    }
}

