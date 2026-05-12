package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {
    private final By heading = By.cssSelector("h3");
    private final By jsAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    private final By jsConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    private final By jsPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    private final By result = By.id("result");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.alerts");
    }

    public String acceptJavaScriptAlert() {
        click(jsAlertButton);
        acceptAlert();
        return getResultText();
    }

    public String dismissJavaScriptConfirm() {
        click(jsConfirmButton);
        dismissAlert();
        return getResultText();
    }

    public String acceptJavaScriptConfirm() {
        click(jsConfirmButton);
        acceptAlert();
        return getResultText();
    }

    public String submitJavaScriptPrompt(String value) {
        click(jsPromptButton);
        enterTextAndAcceptAlert(value);
        return getResultText();
    }

    public String dismissJavaScriptPrompt() {
        click(jsPromptButton);
        dismissAlert();
        return getResultText();
    }

    public String getResultText() {
        return textOf(result);
    }

    public String getHeading() {
        return textOf(heading);
    }

    public boolean isAlertButtonVisible() {
        return isDisplayed(jsAlertButton);
    }

    public boolean isConfirmButtonVisible() {
        return isDisplayed(jsConfirmButton);
    }

    public boolean isPromptButtonVisible() {
        return isDisplayed(jsPromptButton);
    }
}
