package dede.ugurcan.business.abstracts;

import dede.ugurcan.entities.concreates.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    void login(Customer customer);

    void login(String email, String password);

    boolean isValidEmail(String email);

    boolean isStrongPassword(String password);

}

