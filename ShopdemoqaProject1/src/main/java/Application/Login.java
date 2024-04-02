package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
        private WebDriver driver;
        private By usernameField = By.id("//*[@id=\"username\"]");
        private By passwordField = By.id("//*[@id=\"password\"]");
        private By loginButton = By.cssSelector("//*[@id=\"customer_login\"]/div[1]/form/p[3]/button");
        public Login(WebDriver driver) {
            this.driver = driver;
        }

        public void setUsername(String username){
            driver.findElement(usernameField).sendKeys(username);
        }
        public void setPassword(String password){
            driver.findElement(passwordField).sendKeys(password);
        }
        public MyAccount clickLoginButton(){
            driver.findElement(loginButton).click();
            return new MyAccount(driver);
        }
}