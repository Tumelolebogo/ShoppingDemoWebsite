package login;

import Application.HomePage;
import Application.Login;
import Application.MyAccount;
import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class LoginTests extends BaseTests {
    @Test
    public void testSuccessfulLogin(){
        Login loginPage =homePage.clickShopDemoQa();
        loginPage.setUsername("Thabiso2024");
        loginPage.setPassword("Thabiso2024@");
        MyAccount myAccountPage = loginPage.clickLoginButton();
        assertTrue(myAccountPage.getAlertText().contains("Hello! x"), "Alert text is incorrect");

    }
}
