package ui;

import io.qameta.allure.Step;
import ui.pages.AccountPage;
import ui.pages.LoginPage;
import org.testng.annotations.*;
import ui.core.TestListener;
import ui.data.TestData;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

@Listeners(TestListener.class)
public class LogoutTest extends TestBase {

    private LoginPage loginPage;
    private AccountPage accountPage;

    @Test(description = "Check user can log out from system")
    public void checkUserLogout() {
        if (accountPage.userIsLoggedIn()) {
            accountPage.header.clickLogoutButton();
            assertTrue(loginPage.userOnLoginPage());
        } else {
            fail(TestData.LOGIN_ERROR);
        }
    }

    @Step("Actions performed before tests")
    private void beforeTests() {
        loginPage = pageFactory.getLoginPage();
        accountPage = pageFactory.getAccountPage();
        loginPage.openLoginPage()
                .loginUser(TestData.TEST_EMAIL, TestData.TEST_PASSWORD);
    }
}
