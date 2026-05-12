package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DropdownPage extends BasePage {
    private final By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.dropdown");
    }

    public void selectOption(String option) {
        selectByVisibleText(dropdown, option);
    }

    public String getSelectedOption() {
        return selectedOptionText(dropdown);
    }

    public int getOptionCount() {
        return selectOptions(dropdown).size();
    }

    public List<String> getOptionLabels() {
        return selectOptions(dropdown).stream()
                .map(option -> option.getText().trim())
                .toList();
    }

    public boolean isDropdownVisible() {
        return isDisplayed(dropdown);
    }
}
