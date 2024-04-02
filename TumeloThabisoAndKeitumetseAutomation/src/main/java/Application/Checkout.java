package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private final WebDriver driver;

    public Checkout(WebDriver driver) {
        this.driver = driver;
    }

    public void proceedToCheckout() {
        driver.findElement(By.id("checkoutButton")).click();
    }

    public void completeOrder(String shippingAddress, String paymentInfo) {
        driver.findElement(By.id("shippingAddress")).sendKeys(shippingAddress);
        driver.findElement(By.id("paymentInfo")).sendKeys(paymentInfo);
        driver.findElement(By.id("placeOrderButton")).click();
    }
}
