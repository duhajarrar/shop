package Patterns.Iterator;
import java.util.List;
import Models.Store;

public class StoreManagement {
    private List<Store> stores;

    public StoreManagement(List<Store> stores) {
        this.stores = stores;
    }

    public StoreIterator getStoreIterator() {
        return new StoreIterator(stores);
    }
}


