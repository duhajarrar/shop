package Patterns.Iterator;
import java.util.List;
import Models.Item;

public class ItemManagement {
    private List<Item> items;

    public ItemManagement(List<Item> items) {
        this.items = items;
    }

    public ItemIterator getItemIterator() {
        return new ItemIterator(items);
    }
}

