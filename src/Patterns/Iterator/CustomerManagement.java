package Patterns.Iterator;
import java.util.List;

import Models.Customer;
public class CustomerManagement {
    private List<Customer> customers;

    public CustomerManagement(List<Customer> customers) {
        this.customers = customers;
    }

    public CustomerIterator getCustomerIterator() {
        return new CustomerIterator(customers);
    }
}
