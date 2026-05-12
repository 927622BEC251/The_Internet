package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.ConfigReader;
import com.internetbot.config.TestDataReader;
import com.internetbot.data.LoginDataProvider;
import com.internetbot.data.LoginScenario;
import com.internetbot.pages.LoginPage;
import com.internetbot.pages.SecureAreaPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest {
    @Test(dataProvider = "loginScenarios", dataProviderClass = LoginDataProvider.class)
    public void verifyFormAuthenticationForValidAndInvalidCredentials(LoginScenario scenario) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        SecureAreaPage secureAreaPage = loginPage.login(
                ConfigReader.get(scenario.getUsernameKey()),
                ConfigReader.get(scenario.getPasswordKey()));

        String actualMessage = scenario.isValid()
                ? secureAreaPage.getFlashMessage()
                : loginPage.getFlashMessage();

        Assert.assertTrue(actualMessage.contains(TestDataReader.get(scenario.getExpectedMessageKey())));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyLoginPageHeadingIsDisplayed() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertEquals(loginPage.getHeading(), TestDataReader.get("login.page.heading"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyUsernameInputIsVisible() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertTrue(loginPage.isUsernameInputVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyPasswordInputIsVisible() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertTrue(loginPage.isPasswordInputVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyLoginButtonIsVisible() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertTrue(loginPage.isLoginButtonVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyLoginButtonIsEnabled() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertTrue(loginPage.isLoginButtonEnabled());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyPasswordInputUsesPasswordType() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertEquals(loginPage.getPasswordInputType(), "password");
        System.out.println("Test Passed");
    }

    @Test
    public void verifySuccessMessageAfterSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        SecureAreaPage secureAreaPage = loginPage.login(
                ConfigReader.get("form.username"),
                ConfigReader.get("form.password"));

        Assert.assertEquals(secureAreaPage.getHeading(), TestDataReader.get("secure.area.heading"));
        Assert.assertTrue(secureAreaPage.getFlashMessage().contains(TestDataReader.get("login.success.message")));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyLogoutRedirectsToLoginPage() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        SecureAreaPage secureAreaPage = loginPage.login(
                ConfigReader.get("form.username"),
                ConfigReader.get("form.password"));
        LoginPage redirectedLoginPage = secureAreaPage.logout();

        Assert.assertEquals(redirectedLoginPage.getHeading(), TestDataReader.get("login.page.heading"));
        Assert.assertTrue(redirectedLoginPage.getFlashMessage().contains(TestDataReader.get("logout.message")));
        System.out.println("Test Passed");
    }
}
