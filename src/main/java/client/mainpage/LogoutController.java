package client.mainpage;

import client.loginpage.GreenBeamApplication;

public class LogoutController {

    public void logout() {
        GreenBeamApplication application = new GreenBeamApplication();
        application.closeApplication();
    }
}
