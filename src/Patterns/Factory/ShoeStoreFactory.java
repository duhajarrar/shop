package Patterns.Factory;

import Models.Store;
import Models.Stores.ShoeStore;

public class ShoeStoreFactory implements StoreFactory{

    private static ShoeStoreFactory instance;
    ItemFactory shoeFactory;

    private ShoeStoreFactory() {
        this.shoeFactory = ShoeFactory.getInstance();
    }

    public static ShoeStoreFactory getInstance() {
        if (instance == null) {
            instance = new ShoeStoreFactory();
        }
        return instance;
    }

    @Override
    public Store createStore(String storeName) {
        return new ShoeStore(storeName);  
    }

    public ItemFactory getItemFactory() {
        return shoeFactory;
    }

    
}
