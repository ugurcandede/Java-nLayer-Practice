package dede.ugurcan.business.concreates;

import dede.ugurcan.business.abstracts.CustomerMailService;

public class CustomerMailManager implements CustomerMailService {
    @Override
    public void sendConfirmationMail(String message) {
        System.out.println("Duğrulama maili gönderildi " + message);
    }
}
