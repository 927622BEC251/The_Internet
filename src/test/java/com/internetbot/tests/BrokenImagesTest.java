package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.pages.BrokenImagesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BrokenImagesTest extends BaseTest {
    @Test
    public void verifyBrokenImagesCanBeDetected() {
        BrokenImagesPage brokenImagesPage = new BrokenImagesPage(getDriver());
        brokenImagesPage.open();

        Assert.assertTrue(brokenImagesPage.countBrokenImages() > 0);
        Assert.assertTrue(brokenImagesPage.hasAtLeastOneWorkingImage());
        System.out.println("Test Passed");
    }
}
