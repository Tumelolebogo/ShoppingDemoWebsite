package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Confirmation  {
    private final WebDriver driver;

    public Confirmation(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOrderConfirmed() {
        return driver.findElement(By.id("confirmationMessage")).isDisplayed();
    }
}