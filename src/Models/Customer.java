package Models;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String password; 
    private boolean isAuthorized;
    private ShoppingCart shoppingCart;
    private Store store;
    private List<Order> orders;

    public Customer(String customerName, String password) {
        this.customerName = customerName;
        this.password = password;
        this.isAuthorized = false;
        this.orders = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public boolean isAuthorized() {
        return this.isAuthorized;
    }
    
    public void setAuthorized(boolean isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
    
    @Override
    public String toString() {
        return "Customer [customerName=" + customerName + ", isAuthorized=" + isAuthorized
                + ", shoppingCart=" + shoppingCart + ", store=" + store + "]";
    }

   

}

