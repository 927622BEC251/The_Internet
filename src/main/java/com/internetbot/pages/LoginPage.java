package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By usernameInput = By.id("username");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By flashMessage = By.id("flash");
    private final By heading = By.cssSelector("h2");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.login");
    }

    public SecureAreaPage login(String username, String password) {
        type(usernameInput, username);
        type(passwordInput, password);
        click(loginButton);
        return new SecureAreaPage(driver);
    }

    public String getFlashMessage() {
        return textOf(flashMessage);
    }

    public String getHeading() {
        return textOf(heading);
    }

    public boolean isUsernameInputVisible() {
        return isDisplayed(usernameInput);
    }

    public boolean isPasswordInputVisible() {
        return isDisplayed(passwordInput);
    }

    public boolean isLoginButtonVisible() {
        return isDisplayed(loginButton);
    }

    public boolean isLoginButtonEnabled() {
        return isEnabled(loginButton);
    }

    public String getUsernameInputType() {
        return attributeOf(usernameInput, "type");
    }

    public String getPasswordInputType() {
        return attributeOf(passwordInput, "type");
    }

    public String getCurrentUrl() {
        return currentUrl();
    }
}
