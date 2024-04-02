package Application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final By shopDemoQaLink = By.linkText("//*[@id=\"noo-site\"]/header/div[2]/div/div/div/div/a/img");
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public Login clickShopDemoQa(){
        driver.findElement(shopDemoQaLink).click();
        return new Login(driver);
    }
}
