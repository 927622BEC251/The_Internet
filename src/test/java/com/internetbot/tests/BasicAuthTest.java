package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    @Test
    public void verifyBasicAuthenticationSucceedsWithConfiguredCredentials() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        basicAuthPage.openWithCredentials();

        Assert.assertEquals(basicAuthPage.getSuccessMessage(), TestDataReader.get("basic.auth.success.message"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyBasicAuthSuccessMessageIsVisible() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        basicAuthPage.openWithCredentials();

        Assert.assertTrue(basicAuthPage.isSuccessMessageVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyBasicAuthUrlContainsProtectedPath() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        basicAuthPage.openWithCredentials();

        Assert.assertTrue(basicAuthPage.getCurrentUrl().contains("basic_auth"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyBasicAuthPageTitleIsTheInternet() {
        BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());
        basicAuthPage.openWithCredentials();

        Assert.assertEquals(basicAuthPage.getPageTitle(), TestDataReader.get("internet.page.title"));
        System.out.println("Test Passed");
    }
}
