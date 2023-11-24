package Patterns.Memento;

import java.util.ArrayList;
import java.util.List;

import Models.Item;

public class ShoppingCartMemento {
    private List<Item> items;

    public ShoppingCartMemento(List<Item> items) {
        this.items = new ArrayList<>(items);
    }

    public List<Item> getSavedItems() {
        return items;
    }
}