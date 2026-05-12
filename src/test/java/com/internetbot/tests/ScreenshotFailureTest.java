package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScreenshotFailureTest extends BaseTest {
    @Test
    public void verifyLoginPageOpensForScreenshotDemo() {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();

        Assert.assertEquals(loginPage.getHeading(), TestDataReader.get("login.page.heading"));
        System.out.println("Test Passed");
    }
}
