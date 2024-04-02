package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Confirmation {
    private WebDriver driver;

    public Confirmation(WebDriver driver) {

        this.driver = driver;
    }

    public String getConfirmationMessage() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@class='confirmation-message']"));
        return confirmationMessage.getText();
    }
}
