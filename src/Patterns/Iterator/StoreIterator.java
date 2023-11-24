package Patterns.Iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import Models.Store;

public class StoreIterator implements Iterator<Store>{
    
    private List<Store> stores;
    private int position;

    public StoreIterator(List<Store> stores) {
        this.stores = stores;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < stores.size();
    }

    @Override
    public Store next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more stores.");
        }
        return stores.get(position++);   
    }
    
}

