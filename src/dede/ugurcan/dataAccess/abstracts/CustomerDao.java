package dede.ugurcan.dataAccess.abstracts;

import dede.ugurcan.entities.concreates.Customer;

import java.util.List;

public interface CustomerDao {
    void addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAllCustomer();
}
