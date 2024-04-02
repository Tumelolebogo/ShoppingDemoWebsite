package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout {
    private WebDriver driver;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.linkText("Proceed to checkout"));
        checkoutButton.click();
    }
}
