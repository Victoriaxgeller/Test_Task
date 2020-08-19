package ui.core;

import ui.pages.AccountPage;
import ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private WebDriver driver;
    private Browser browser;

    public PageFactory(WebDriver driver, Browser browser) {
        this.driver = driver;
        this.browser = browser;
    }

    public AccountPage getAccountPage() {
        return new AccountPage(driver, browser);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver, browser);
    }

}
