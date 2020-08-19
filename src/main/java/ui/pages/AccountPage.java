package ui.pages;

import ui.core.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.page.elements.Header;

public class AccountPage {
    public Header header;
    public final String LOGOUT_RELATIVE_URL = "account/logout/";
    private Browser browser;
    private final String PAGE_TITLE = "MY ACCOUNT";

    public AccountPage(WebDriver driver, Browser browser) {
        PageFactory.initElements(driver, this);
        header = new Header(driver, browser);
        this.browser = browser;
    }

    @FindBy(css = ".page-heading")
    private WebElement accountHeading;

    @Step("Check user is logged in")
    public boolean userIsLoggedIn() {
        browser.waitUntilVisible(accountHeading);
        return accountHeading.getText().equals(PAGE_TITLE);
    }
}
