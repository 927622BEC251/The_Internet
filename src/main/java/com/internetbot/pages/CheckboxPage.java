package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckboxPage extends BasePage {
    private final By checkboxes = By.cssSelector("#checkboxes input");
    private final By checkboxOne = By.cssSelector("#checkboxes input:nth-of-type(1)");
    private final By checkboxTwo = By.cssSelector("#checkboxes input:nth-of-type(2)");

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.checkboxes");
    }

    public boolean isFirstCheckboxSelected() {
        return isSelected(checkboxOne);
    }

    public boolean isSecondCheckboxSelected() {
        return isSelected(checkboxTwo);
    }

    public void toggleFirstCheckbox() {
        click(checkboxOne);
    }

    public void toggleSecondCheckbox() {
        click(checkboxTwo);
    }

    public int getCheckboxCount() {
        return findAll(checkboxes).size();
    }

    public boolean areBothCheckboxesSelected() {
        return isFirstCheckboxSelected() && isSecondCheckboxSelected();
    }
}
