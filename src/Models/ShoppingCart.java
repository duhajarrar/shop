package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Patterns.Memento.ShoppingCartMemento;
import Patterns.Observer.CartObserver;

public class ShoppingCart{
    private List<Item> items;
    private Map<Item, Integer> itemsQuantity = new HashMap<>();
    private List<CartObserver> cartObservers;

    public ShoppingCart() {
        this.items = new ArrayList<>();
        this.cartObservers = new ArrayList<>();
    }

    public Enumeration<Item> items() {
        return Collections.enumeration(items);
    }

    public void displayProducts(){
        int i = 0;
        for (Map.Entry<Item, Integer> entry : itemsQuantity.entrySet()) {
            System.out.println(i+". Order: [" + entry.toString()+"]");
        }
    }

    public void addItem(Item item) {
        items.add(item);
        itemsQuantity.put(item, itemsQuantity.getOrDefault(item, 0) + 1);
        System.out.println(item.toString()+" added successfully to the cart");
        notifyObservers();
    }

    public void removeItem(Item item) {
        items.remove(item);        
        itemsQuantity.remove(item);
        System.out.println(item.toString()+" removed successfully to the cart");
        notifyObservers();
    }

    public void decressItemQuantity(Item item) {       
        if(itemsQuantity.getOrDefault(item, 0) - 1 > 0){
            itemsQuantity.remove(item, itemsQuantity.getOrDefault(item, 0) - 1);
            System.out.println("");
        }else{
            itemsQuantity.remove(item);
            items.remove(item);
        }
        System.out.println(item.toString()+" removed successfully to the cart");
        notifyObservers();
    }
    
    public void addObserver(CartObserver cartObserver) {
        cartObservers.add(cartObserver);
    }

    
    public void removeObserver(CartObserver cartObserver) {
        cartObservers.remove(cartObserver);
    }

    
    public void notifyObservers() {
        for (CartObserver cartObservers : cartObservers) {
            cartObservers.update(this);
        }
        System.out.println("Shopping Cart Updated Successfully");
    }

    public ShoppingCartMemento saveToMemento() {
        notifyObservers();
        return new ShoppingCartMemento(this.items);
    }

    public void restoreFromMemento(ShoppingCartMemento memento) {
        items = memento.getSavedItems();
        notifyObservers();
    }

    public List<Item> getItems() {
        return items;
    }
    
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void setItemsQuantity(Map<Item, Integer> itemsQuantity) {
        this.itemsQuantity = itemsQuantity;
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Item, Integer> entry : itemsQuantity.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    @Override
    public String toString() {
        return "ShoppingCart [items and quantities=" + itemsQuantity + "]";
    }

    

   

}
