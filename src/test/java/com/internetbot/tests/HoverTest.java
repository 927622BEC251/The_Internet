package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.HoverPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverTest extends BaseTest {
    @Test
    public void verifyHoverDisplaysProfileName() {
        HoverPage hoverPage = new HoverPage(getDriver());
        hoverPage.open();

        Assert.assertEquals(hoverPage.hoverFirstProfileAndGetName(), TestDataReader.get("hover.profile.name"));
        System.out.println("Test Passed");
    }
}
