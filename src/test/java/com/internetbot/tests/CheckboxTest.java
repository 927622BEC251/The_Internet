package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.CheckboxPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    @Test
    public void verifyFirstCheckboxCanBeCheckedAndUnchecked() {
        CheckboxPage checkboxPage = new CheckboxPage(getDriver());
        checkboxPage.open();

        Assert.assertFalse(checkboxPage.isFirstCheckboxSelected());
        checkboxPage.toggleFirstCheckbox();
        Assert.assertTrue(checkboxPage.isFirstCheckboxSelected());
        checkboxPage.toggleFirstCheckbox();
        Assert.assertFalse(checkboxPage.isFirstCheckboxSelected());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyCheckboxPageShowsTwoCheckboxes() {
        CheckboxPage checkboxPage = new CheckboxPage(getDriver());
        checkboxPage.open();

        Assert.assertEquals(checkboxPage.getCheckboxCount(), TestDataReader.getInt("checkbox.count"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyFirstCheckboxDefaultUnchecked() {
        CheckboxPage checkboxPage = new CheckboxPage(getDriver());
        checkboxPage.open();

        Assert.assertFalse(checkboxPage.isFirstCheckboxSelected());
        System.out.println("Test Passed");
    }

    @Test
    public void verifySecondCheckboxDefaultChecked() {
        CheckboxPage checkboxPage = new CheckboxPage(getDriver());
        checkboxPage.open();

        Assert.assertTrue(checkboxPage.isSecondCheckboxSelected());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyBothCheckboxesCanBeSelectedTogether() {
        CheckboxPage checkboxPage = new CheckboxPage(getDriver());
        checkboxPage.open();

        checkboxPage.toggleFirstCheckbox();

        Assert.assertTrue(checkboxPage.areBothCheckboxesSelected());
        System.out.println("Test Passed");
    }

    @Test
    public void verifySecondCheckboxStateCanBeToggledAndReverified() {
        CheckboxPage checkboxPage = new CheckboxPage(getDriver());
        checkboxPage.open();

        Assert.assertTrue(checkboxPage.isSecondCheckboxSelected());
        checkboxPage.toggleSecondCheckbox();
        Assert.assertFalse(checkboxPage.isSecondCheckboxSelected());
        checkboxPage.toggleSecondCheckbox();
        Assert.assertTrue(checkboxPage.isSecondCheckboxSelected());
        System.out.println("Test Passed");
    }
}
