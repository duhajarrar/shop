package Patterns.Factory;

import Models.Item;

public interface ItemFactory {
    Item createItem(String itemName, int storeId, double price);
}