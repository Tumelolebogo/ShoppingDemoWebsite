package ApplicationTest;

import Application.*;
import Reporting.TestReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class ShoppingTest {
    private WebDriver driver;
    private TestReporter reporter;
    private Login login;
    private Products products;
    private Checkout checkout;
    private Confirmation confirmation;


    @BeforeClass
    @Parameters({"url", "browser"})
    public void setUp(String url, String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/data/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/data/geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }



        driver.manage().window().maximize(); // Maximize the browser window
        driver.get("https://shop.demoqa.com/shop/"); // Open the specified URL

        // Initialize test objects
        reporter = new TestReporter("C:\\Users\\maiteleamo\\IdeaProjects\\TumeloThabisoAndKeitumetseAutomation\\target");
        login = new Login(driver);
        /*products = new Products(driver);
        Cart cart = new Cart(driver);
        checkout = new Checkout(driver);
        confirmation = new Confirmation(driver); */
        // For example: login.doLogin(), products.selectProduct(), etc.
    }

    @Test(priority = 1)
    public void invalidLoginEndsOnLoginPage(){
        reporter.createTest("Invalid Login Ends on Login Page Test");

        login.login("invalid_username","invalid_password");

        if(driver.getCurrentUrl().equals("https://shop.demoqa.com/my-account/")){
            reporter.logTestStatus("Invalid Login ended on Login page as expected",true);
        } else {
            reporter.logTestStatus("Invalid Login did not end on login page as expected",false);
        }
    }

    @Test(priority = 2)
    public void LoginAddSaleItemToCartLogout() {
        reporter.createTest("Login, Add Sale Item to Cart, Logout Test");

        login.login("valid_username", "valid_password");
        reporter.logTestStatus("Login successful", true);

        products.addItemToCart("SALE_ITEM");
        reporter.logTestStatus("Sale item added to cart", true);

        checkout.proceedToCheckout();
        checkout.completeOrder("shipping_address", "payment_info");

        // Validate order confirmation
        reporter.logTestStatus("Order Confirmation", confirmation.isOrderConfirmed());
        reporter.addScreenshot("path_to_screenshot.png");
    }

    @Test(priority = 3)
    public void loginAddAnotherItemCheckoutCompleteOrder(){
        reporter.createTest("Login, Add Another Item, Checkout, Complete Order Test");

        login.login("valid_username","valid_password");
        reporter.logTestStatus("Login successful",true);

        products.addItemToCart("BLACK LUX GRAPHIC T-SHIRT");
        reporter.logTestStatus("Another item added to cart", true);

        checkout.proceedToCheckout();
        reporter.logTestStatus("Proceed to checkout", true);

        checkout.completeOrder("shipping address", "payment info");
        reporter.logTestStatus("order completed", true);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        reporter.logTestStatus(result);
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        reporter.flushReport();
    }
}

