package Patterns.Factory;

import Models.Store;
import Models.Stores.BookStore;

public class BookStoreFactory implements StoreFactory {

    private static BookStoreFactory instance;
    ItemFactory bookFactory;
    private BookStoreFactory(){
        this.bookFactory = BookFactory.getInstance();
    }

    public static BookStoreFactory getInstance() {
        if (instance == null) {
            instance = new BookStoreFactory();
        }
        return instance;
    }

    @Override
    public Store createStore(String storeName) {
        return new BookStore(storeName);
    }

    public ItemFactory getItemFactory() {
        return bookFactory;
    }
    
    
}
