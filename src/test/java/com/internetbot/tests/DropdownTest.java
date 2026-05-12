package com.internetbot.tests;

import com.internetbot.base.BaseTest;
import com.internetbot.config.TestDataReader;
import com.internetbot.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends BaseTest {
    @Test
    public void verifyEachDropdownOptionCanBeSelected() {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.open();

        dropdownPage.selectOption(TestDataReader.get("dropdown.option.one"));
        Assert.assertEquals(dropdownPage.getSelectedOption(), TestDataReader.get("dropdown.option.one"));

        dropdownPage.selectOption(TestDataReader.get("dropdown.option.two"));
        Assert.assertEquals(dropdownPage.getSelectedOption(), TestDataReader.get("dropdown.option.two"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyDropdownIsVisible() {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.open();

        Assert.assertTrue(dropdownPage.isDropdownVisible());
        System.out.println("Test Passed");
    }

    @Test
    public void verifyDefaultDropdownOptionIsSelected() {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.open();

        Assert.assertEquals(dropdownPage.getSelectedOption(), TestDataReader.get("dropdown.default.option"));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyDropdownLabelsContainExpectedOptions() {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.open();

        Assert.assertTrue(dropdownPage.getOptionLabels().contains(TestDataReader.get("dropdown.option.one")));
        Assert.assertTrue(dropdownPage.getOptionLabels().contains(TestDataReader.get("dropdown.option.two")));
        System.out.println("Test Passed");
    }

    @Test
    public void verifyDropdownShowsCorrectNumberOfOptions() {
        DropdownPage dropdownPage = new DropdownPage(getDriver());
        dropdownPage.open();

        Assert.assertEquals(dropdownPage.getOptionCount(), TestDataReader.getInt("dropdown.option.count"));
        System.out.println("Test Passed");
    }
}
