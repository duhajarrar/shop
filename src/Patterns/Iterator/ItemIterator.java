package Patterns.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Models.Item;

public class ItemIterator implements Iterator<Item>{
    private List<Item> items;
    private int position;

    public ItemIterator(List<Item> items) {
        this.items = items;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Item next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more items.");
        }
        return items.get(position++);   
    }
    
}
