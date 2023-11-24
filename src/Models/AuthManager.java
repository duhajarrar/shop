package Models;
import java.util.HashMap;
import java.util.Map;

public class AuthManager {
    private Map<String, Customer> customers;

    public AuthManager() {
        this.customers = new HashMap<>();
    }

    public boolean signUp(String username, String password) {
        if (customers.containsKey(username)) {
            System.out.println("Signup failed: Username already exists.");
            return false;
        }
        customers.put(username, new Customer(username, password));
        System.out.println("Signup successful for username: " + username);
        return true;
    }

    public Customer login(String username, String password) {
        Customer customer = customers.get(username);
        if (customer != null && customer.checkPassword(password)) {
            System.out.println("Login successful for username: " + username);
            customer.setAuthorized(true);
            return customer;
        }
        System.out.println("Login failed: Invalid username or password.");
        
        return null;
    }

    public void logout(Customer customer) {
        if (customer != null) {
            customer.setAuthorized(false);
            System.out.println("Logged out successful for username: " + customer.getCustomerName());
   
        }
        
    }
}
