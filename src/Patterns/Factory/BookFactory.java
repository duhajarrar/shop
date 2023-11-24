package Patterns.Factory;

import Models.Item;
import Models.Items.Book;


public class BookFactory implements ItemFactory {

    private static BookFactory instance;

    private BookFactory(){

    }

    public static BookFactory getInstance() {
        if (instance == null) {
            instance = new BookFactory();
        }
        return instance;
    }

    @Override
    public Item createItem(String itemName, int storeId, double price) {
        return new Book(itemName,storeId,price);
    }
    
}
