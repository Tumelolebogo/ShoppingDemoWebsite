package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products {
    private final WebDriver driver;

    public Products(WebDriver driver) {
        this.driver = driver;
    }

    public void addItemToCart(String productName) {
        driver.findElement(By.xpath("//h3[contains(text(), '" + productName + "')]")).click();
        driver.findElement(By.id("addToCartButton")).click();
    }
}
