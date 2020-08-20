package ui;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


public class TestBase {

    protected Browser browser;
    protected WebDriver driver;
    protected PageFactory pageFactory;

    @Parameters("browser")
    @BeforeTest
    public void setUp(@Optional String browserName) {
        driver = Driver.getDriver(browserName);
        browser = new Browser(driver);
        driver.get(Browser.BASE_URL);
        pageFactory = new PageFactory(driver, browser);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
