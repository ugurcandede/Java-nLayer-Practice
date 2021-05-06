package dede.ugurcan.dataAccess.concreates;

import dede.ugurcan.dataAccess.abstracts.CustomerDao;
import dede.ugurcan.entities.concreates.Customer;

import java.util.List;

public class HibernateCustomerDao implements CustomerDao {

    @Override
    public void addCustomer(Customer customer) {
        System.out.println("Hibernate ile eklendi => " + customer.getEmail());
    }

    @Override
    public void updateCustomer(Customer customer) {
        System.out.println("Hibernate ile güncellendi => " + customer.getEmail());
    }

    @Override
    public Customer getCustomer(int id) {
        return null;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }
}
