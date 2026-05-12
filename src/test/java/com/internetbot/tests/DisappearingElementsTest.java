package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.pages.DisappearingElementsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisappearingElementsTest extends BaseTest {
    @Test
    public void verifyDisappearingElementReappearsOnRefresh() {
        DisappearingElementsPage disappearingElementsPage = new DisappearingElementsPage(getDriver());
        disappearingElementsPage.open();

        Assert.assertTrue(disappearingElementsPage.refreshUntilGalleryAppears(10));
        System.out.println("Test Passed");
    }
}
