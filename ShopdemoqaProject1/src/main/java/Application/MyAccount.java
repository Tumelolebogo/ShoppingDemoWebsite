package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
    private WebDriver driver;
    private By statusAlert = By.id("Hello");
    public MyAccount(WebDriver driver){
        this.driver = driver;
    }
    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}
