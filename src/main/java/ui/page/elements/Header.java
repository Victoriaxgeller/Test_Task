package ui.page.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ui.Browser;

public class Header {

    private WebDriver driver;
    private Browser browser;

    public Header(WebDriver driver, Browser browser) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.browser = browser;
    }

    @FindBy(css = ".logout")
    private WebElement logOutButton;

    @Step("Click logout button")
    public void clickLogoutButton() {
        logOutButton.click();
    }
}
