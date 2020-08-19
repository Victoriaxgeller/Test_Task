package ui.core;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Browser {

    private Logger logger = LoggerFactory.getLogger(Browser.class);
    public static String BASE_URL = "http://automationpractice.com/";
    private WebDriver driver;

    public Browser(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open URL: {0}")
    public void openUrl(String url) {
        String absoluteUrlToOpen = BASE_URL + url;
        logger.info(absoluteUrlToOpen);
        driver.get(absoluteUrlToOpen);
        WebDriverWait wait = new WebDriverWait(driver, 10, 2);
        wait.until(ExpectedConditions.urlContains(absoluteUrlToOpen));
    }

    public void waitUntilVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 10, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
