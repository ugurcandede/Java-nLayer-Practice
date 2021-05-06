package dede.ugurcan.core.concreates;

import dede.ugurcan.core.abstracts.LoginService;
import dede.ugurcan.googleLogin.GLogin;

public class LoginSystemAdapter implements LoginService {

    @Override
    public void loginToSystem(String message) {
        GLogin gLogin = new GLogin();
        System.out.println("LoginSystemAdapter ile giriş bağlantısı kuruluyor");
        gLogin.login(message);
    }
}
