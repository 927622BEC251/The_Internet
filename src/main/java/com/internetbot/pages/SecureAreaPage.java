package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {
    private final By heading = By.cssSelector("h2");
    private final By logoutButton = By.cssSelector("a.button[href='/logout']");
    private final By flashMessage = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public String getHeading() {
        return textOf(heading);
    }

    public String getFlashMessage() {
        return textOf(flashMessage);
    }

    public boolean isLogoutButtonVisible() {
        return isDisplayed(logoutButton);
    }

    public LoginPage logout() {
        clickWithJavaScript(logoutButton);
        waitForUrlContains("/login");
        return new LoginPage(driver);
    }
}
