package Patterns.Iterator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import Models.Customer;

public class CustomerIterator implements Iterator<Customer> {
    private List<Customer> customers;
    private int position;

    public CustomerIterator(List<Customer> customers) {
        this.customers = customers;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < customers.size();
    }

    @Override
    public Customer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more customers.");
        }
        return customers.get(position++);   
    }
    
}
