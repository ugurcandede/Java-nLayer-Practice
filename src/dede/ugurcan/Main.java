package dede.ugurcan;

import dede.ugurcan.business.abstracts.CustomerService;
import dede.ugurcan.business.concreates.CustomerMailManager;
import dede.ugurcan.business.concreates.CustomerManager;
import dede.ugurcan.core.concreates.LoginSystemAdapter;
import dede.ugurcan.dataAccess.concreates.HibernateCustomerDao;
import dede.ugurcan.entities.concreates.Customer;

public class Main {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerManager(new HibernateCustomerDao(), new LoginSystemAdapter(), new CustomerMailManager());

        Customer c1 = new Customer("Ugurcan", "Dede", "ugurcan@dede.com", "123456789");
        Customer c2 = new Customer("Ugurcan", "D", "ugurcan@dede", "1234");

        customerService.addCustomer(c1);
        customerService.addCustomer(c2);

//        customerService.login(c1);
        customerService.login("ugurcan@dede.com", "123456789");
    }
}





