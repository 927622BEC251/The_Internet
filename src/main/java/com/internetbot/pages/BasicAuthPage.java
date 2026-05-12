package com.internetbot.pages;

import com.internetbot.config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasicAuthPage extends BasePage {
    private final By successMessage = By.cssSelector(".example p");

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    public void openWithCredentials() {
        String baseUrl = ConfigReader.get("base.url").replace("https://", "");
        String username = ConfigReader.get("basic.auth.username");
        String password = ConfigReader.get("basic.auth.password");
        driver.get("https://" + username + ":" + password + "@" + baseUrl + ConfigReader.get("path.basic.auth"));
    }

    public String getSuccessMessage() {
        return textOf(successMessage);
    }

    public boolean isSuccessMessageVisible() {
        return isDisplayed(successMessage);
    }

    public String getCurrentUrl() {
        return currentUrl();
    }

    public String getPageTitle() {
        return title();
    }
}
