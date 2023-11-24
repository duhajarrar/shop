package Models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Mall {
    private static Mall instance = null;

    private String mallName;
    private List<Store> stores;
    private List<Customer> customers;

    
    private Mall() {
        this.mallName = "City Mall";
        this.stores = new ArrayList<>();
        this.customers =  new ArrayList<>();
    }

    public static Mall getInstance() {
        if (instance == null) {
            instance = new Mall();
        }
        return instance;
    }

    public void enter(Customer c){
        if (c != null && !customers.contains(c)) {
            customers.add(c);
            System.out.println(c.getCustomerName() + " entered the "+getMallName());
        }
    }
    
    public void exit(Customer c){
        if (c != null && customers.contains(c)) {
            customers.remove(c);
            System.out.println(c.getCustomerName()+" left the "+getMallName());
        }
        
    }
    
    public ShoppingCart getShoppingCart(){
        return new ShoppingCart();
    }

    public Enumeration<Customer> customers(){
        return Collections.enumeration(customers);
    }

    public Enumeration<Store> stores(){
        return Collections.enumeration(stores);
    }
    
    public void displayStores(){
        Enumeration<Store> storesEnumeration = stores();
        int i = 0;
        while (storesEnumeration.hasMoreElements()){
            System.out.println(i+". " + storesEnumeration.nextElement().getStoreName());
            i++;
        }
    }

    public int getStoresCount(){
        return this.stores.size();
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public void addStore(Store store){
        if(store != null){
            System.out.println("Store "+store.getStoreName()+" added successfully to the mall");
            stores.add(store);
        }
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    @Override
    public String toString() {
        return "Mall [mallName=" + mallName + ", stores=" + stores + ", customers=" + customers + "]";
    }


    
}
