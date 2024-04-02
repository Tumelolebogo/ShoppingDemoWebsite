package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class Cart {
        private WebDriver driver;

        public Cart(WebDriver driver) {
            this.driver = driver;
        }

        public void addItemToCart(String productName) {
            WebElement productLink = driver.findElement(By.linkText(productName));
            productLink.click();
            WebElement addToCartButton = driver.findElement(By.name("add-to-cart"));
            addToCartButton.click();
        }
}
