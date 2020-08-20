package ui.pages;

import ui.Browser;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final String RELATIVE_URL = "index.php?controller=authentication&back=my-account";

    private Browser browser;

    public LoginPage(WebDriver driver, Browser browser) {
        PageFactory.initElements(driver, this);
        this.browser = browser;
    }

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#passwd")
    private WebElement passwordField;

    @FindBy(css = "#SubmitLogin")
    private WebElement submitButton;

    @FindBy(css = "#create-account_form")
    private WebElement registrationForm;

    @Step("Open login page")
    public LoginPage openLoginPage() {
        browser.openUrl(RELATIVE_URL);
        return this;
    }

    @Step("Set email: {0}")
    public LoginPage setEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
        return this;
    }

    @Step("Set password: {0}")
    public LoginPage setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click login submit button")
    public void clickSubmitButton() {
        submitButton.click();
    }

    @Step("Check user is on login page")
    public boolean userOnLoginPage() {
        browser.waitUntilVisible(registrationForm);
        return registrationForm.isDisplayed();
    }

    @Step("Login user with email: {0} and password: {1}")
    public void loginUser(String email, String password) {
        setEmail(email)
                .setPassword(password)
                .clickSubmitButton();
    }
}
