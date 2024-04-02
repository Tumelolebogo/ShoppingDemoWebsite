package base;
import Application.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\maiteleamo\\IdeaProjects\\ShopdemoqaProject1\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.get("https://shop.demoqa.com/my-account/");


        System.out.println(driver.getTitle());
        driver.quit();
    }
   /* @AfterClass
    public void tearDown(){
        driver.quit();
    } */
}
