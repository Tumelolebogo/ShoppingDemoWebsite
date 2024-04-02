package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cart {
    private final WebDriver driver ;

    public Cart(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyItemAdded(String productName) {
        String message = driver.findElement(By.className("addedToCartMessage")).getText();
        Assert.assertTrue(message.contains(productName + " added to cart"), "Item not added to cart");
    }
}
