package Models.Stores;

import java.util.Enumeration;

import Models.Customer;
import Models.Mall;
import Models.Store;
public class BookStore extends Store {
    
    public BookStore(String storeName) {
        super(storeName);
    }

    @Override
    public void enter(Customer c) {
        Enumeration<Customer> mallCustomersEnumeration = Mall.getInstance().customers();
        while(mallCustomersEnumeration.hasMoreElements()){
            if(mallCustomersEnumeration.nextElement().equals(c)){
                System.out.println(c.getCustomerName()+" entered the book store");
                super.addCustomer(c);
                return;
            }
        }
        
        System.out.println(c.getCustomerName()+", before entering the book store you must enter the mall");
    }

    @Override
    public void exit(Customer c) {
        Enumeration<Customer> mallCustomersEnumeration = Mall.getInstance().customers();
        while(mallCustomersEnumeration.hasMoreElements()){
            if(mallCustomersEnumeration.nextElement().equals(c)){
                super.removeCustomer(c);
                System.out.println(c.getCustomerName()+" left the book store");
                return;
            }
        }

        System.out.println(c.getCustomerName()+", You have never been in the store");
    }
    
}
