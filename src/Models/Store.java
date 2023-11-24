package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import Patterns.Observer.CartObserver;

public abstract class Store {
    private static int counter = 0;
    private final int storeId;
    private String storeName;
    private List<Item> items;
    private List<Customer> customers;
    private List<CartObserver> cartObservers;
    
    public Store(String storeName) {
        this.storeId = counter;
        this.storeName = storeName;
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.cartObservers = new ArrayList<>();
        counter ++;
    }

    public abstract void enter(Customer c);
    public abstract void exit(Customer c);
    
    
    public void addItem(Item item) {
        if(item != null){
            System.out.println("Product "+item.getItemName()+" added successfully to the store");
            this.items.add(item);
        }
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public int getStoreId() {
        return storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
   
    public Enumeration<Item> items(){
        return Collections.enumeration(items);
    }

    public void displayProducts(){
        Enumeration<Item> itemsEnumeration = items();
        int i = 0;
        while (itemsEnumeration.hasMoreElements()){
            System.out.println(i+". Product: " + itemsEnumeration.nextElement().getItemName());
            i++;
        }
    }
   
    public Item searchProduct(String itemName){
        Enumeration<Item> itemsEnumeration = items();
        Item item;

        while (itemsEnumeration.hasMoreElements()){
            item = itemsEnumeration.nextElement();
            if(itemName.equals(item.getItemName())){
                return item;
            }
        }
        return null;
    }
    
    public void addObserver(CartObserver cartObserver){
        this.cartObservers.add(cartObserver);
    }

    public void removeObserver(CartObserver cartObserver){
        this.cartObservers.remove(cartObserver);
    }

    public Enumeration<Customer> customers(){
        return Collections.enumeration(customers);
    }

    public void addCustomer(Customer c) {
        if (this.customers.contains(c)) {
            System.out.println("This Customer " + c.getCustomerName() + " already exists.");
        } else {
            customers.add(c);
        }
    }
    
    public void removeCustomer(Customer c) {
        if(this.customers.indexOf(c) != -1)
            this.customers.remove(c);
        else
            System.out.println("This Customer "+c.getCustomerName()+" not exist.");
    }

    public List<Item> getItems() {
        return this.items;
    }

     @Override
    public String toString() {
        return "Store [storeId=" + storeId + ", storeName=" + storeName + ", items=" + items + ", customers="
                + customers + ", cartObservers=" + cartObservers + "]";
    }


}
