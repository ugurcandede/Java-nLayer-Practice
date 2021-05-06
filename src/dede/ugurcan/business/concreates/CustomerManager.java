package dede.ugurcan.business.concreates;

import dede.ugurcan.business.abstracts.CustomerMailService;
import dede.ugurcan.business.abstracts.CustomerService;
import dede.ugurcan.core.abstracts.LoginService;
import dede.ugurcan.dataAccess.abstracts.CustomerDao;
import dede.ugurcan.entities.concreates.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CustomerManager implements CustomerService {
    private final CustomerDao customerDao;
    private final LoginService loginService;
    private final CustomerMailService customerMailService;

    private ArrayList<String> customerList = new ArrayList<>();

    public CustomerManager(CustomerDao customerDao, LoginService loginService, CustomerMailService customerMailService) {
        this.customerDao = customerDao;
        this.loginService = loginService;
        this.customerMailService = customerMailService;
    }

    @Override
    public void addCustomer(Customer customer) {

        isStrongPassword(customer.getPassword());

        if (customer.getFirstName().length() < 2 || customer.getLastName().length() < 2) {
            System.out.println("Ad ve Soyad en az 2 karakterli olmalıdır");
        } else if (customerList.contains(customer.getEmail())) {
            System.out.println(customer.getEmail() + " bu adres kullanılmakta");
        } else if (!isValidEmail(customer.getEmail())) {
            System.out.println("E-mail formatı geçerli değil");
        } else {
            customerList.add(customer.getEmail());
            customerMailService.sendConfirmationMail(customer.getEmail());
            login(customer);
            System.out.println("--------------------------------------\n");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return null;
    }

    @Override
    public void login(Customer customer) {
        System.out.println("--------------------------------------\n");
        if (customerList.contains(customer.getEmail())) {
            System.out.println("Giriş Yapılıyor");
            loginService.loginToSystem(customer.getEmail());
        } else {
            System.out.println("Hata");
        }
    }

    @Override
    public void login(String email, String password) {
        System.out.println("--------------------------------------\n");
        if (customerList.contains(email)) {
            System.out.println("Giriş Yapılıyor");
            loginService.loginToSystem(email);
        } else {
            System.out.println("Giriş yapılırken hata oluştu");
        }
    }

    @Override
    public boolean isValidEmail(String email) {
        final Pattern reg = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);
        return reg.matcher(email).matches();
    }

    @Override
    public boolean isStrongPassword(String password) {
        if (password.length() < 5) {
            System.out.println("Şifreniz en az 5 karakterli olmalıdır");
            return false;
        }
        return true;
    }
}
