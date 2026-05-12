package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.AlertPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends BaseTest {
    @Test
    public void verifyJavaScriptAlertCanBeAccepted() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertEquals(alertPage.acceptJavaScriptAlert(), TestDataReader.get("alert.accept.result"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyAlertPageHeadingIsDisplayed() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertEquals(alertPage.getHeading(), TestDataReader.get("alert.page.heading"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyAlertButtonIsVisible() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertTrue(alertPage.isAlertButtonVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyConfirmButtonIsVisible() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertTrue(alertPage.isConfirmButtonVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyPromptButtonIsVisible() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertTrue(alertPage.isPromptButtonVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyJavaScriptConfirmCanBeDismissed() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertEquals(alertPage.dismissJavaScriptConfirm(), TestDataReader.get("confirm.dismiss.result"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyJavaScriptConfirmCanBeAccepted() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertEquals(alertPage.acceptJavaScriptConfirm(), TestDataReader.get("alert.confirm.accept.result"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyJavaScriptPromptAcceptsEnteredText() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        String result = alertPage.submitJavaScriptPrompt(TestDataReader.get("prompt.input"));

        Assert.assertEquals(result, TestDataReader.get("prompt.result.prefix") + " " + TestDataReader.get("prompt.input"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyJavaScriptPromptCanBeDismissed() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        Assert.assertEquals(alertPage.dismissJavaScriptPrompt(), TestDataReader.get("alert.prompt.dismiss.result"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyResultTextChangesWhenDifferentAlertTypesAreUsed() {
        AlertPage alertPage = new AlertPage(getDriver());
        alertPage.open();

        String alertResult = alertPage.acceptJavaScriptAlert();
        String confirmResult = alertPage.dismissJavaScriptConfirm();

        Assert.assertNotEquals(alertResult, confirmResult);
        Assert.assertEquals(confirmResult, TestDataReader.get("confirm.dismiss.result"));
        System.out.println("Test Passed");
    }
}
