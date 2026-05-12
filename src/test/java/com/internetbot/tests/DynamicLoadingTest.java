package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.DynamicLoadingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicLoadingTest extends BaseTest {
    @Test
    public void verifyDynamicElementAppearsAfterStart() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(getDriver());
        dynamicLoadingPage.open();

        Assert.assertEquals(dynamicLoadingPage.startAndGetLoadedText(), TestDataReader.get("dynamic.loaded.message"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyDynamicLoadingHeadingIsDisplayed() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(getDriver());
        dynamicLoadingPage.open();

        Assert.assertEquals(dynamicLoadingPage.getHeading(), TestDataReader.get("dynamic.page.heading"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyStartButtonIsVisible() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(getDriver());
        dynamicLoadingPage.open();

        Assert.assertTrue(dynamicLoadingPage.isStartButtonVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyStartButtonTextIsCorrect() {
        DynamicLoadingPage dynamicLoadingPage = new DynamicLoadingPage(getDriver());
        dynamicLoadingPage.open();

        Assert.assertEquals(dynamicLoadingPage.getStartButtonText(), TestDataReader.get("dynamic.start.button"));
        System.out.println("Test Passed");
    }
}
