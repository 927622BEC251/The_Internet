package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePage {
    private final By heading = By.cssSelector("h3");
    private final By startButton = By.cssSelector("#start button");
    private final By finishText = By.cssSelector("#finish h4");

    public DynamicLoadingPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.dynamic.loading");
    }

    public String startAndGetLoadedText() {
        click(startButton);
        return waitWithFluentPolling(finishText).getText().trim();
    }

    public String getHeading() {
        return textOf(heading);
    }

    public boolean isStartButtonVisible() {
        return isDisplayed(startButton);
    }

    public String getStartButtonText() {
        return textOf(startButton);
    }
}
