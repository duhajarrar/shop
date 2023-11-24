package Patterns.Factory;

import Models.Item;
import Models.Items.Shoe;

public class ShoeFactory implements ItemFactory{

    private static ShoeFactory instance;

    private ShoeFactory() {}

    public static ShoeFactory getInstance() {
        if (instance == null) {
            instance = new ShoeFactory();
        }
        return instance;
    }

    @Override
    public Item createItem(String itemName, int storeId, double price) {
        return new Shoe(itemName,storeId,price);  
    }
}
