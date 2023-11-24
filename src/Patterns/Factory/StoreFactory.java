package Patterns.Factory;

import Models.Store;

public interface StoreFactory {
    Store createStore(String storeName);
    ItemFactory getItemFactory();
}