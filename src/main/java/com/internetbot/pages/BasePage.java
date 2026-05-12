package com.internetbot.pages;

import com.internetbot.config.ConfigReader;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    protected final WebDriver driver;
    private final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getTimeoutSeconds()));
    }

    protected void openPath(String pathKey) {
        driver.get(ConfigReader.get("base.url") + ConfigReader.get(pathKey));
        pauseForDemo();
    }

    protected WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected List<WebElement> waitForAllVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    protected String currentUrl() {
        return driver.getCurrentUrl();
    }

    protected String title() {
        return driver.getTitle();
    }

    protected void waitForUrlContains(String expectedUrlPart) {
        wait.until(ExpectedConditions.urlContains(expectedUrlPart));
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
        pauseForDemo();
    }

    protected void clickWithJavaScript(By locator) {
        WebElement element = waitForVisible(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        pauseForDemo();
    }

    protected void type(By locator, String value) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(value);
        pauseForDemo();
    }

    protected String textOf(By locator) {
        return waitForVisible(locator).getText().trim();
    }

    protected boolean isDisplayed(By locator) {
        return waitForVisible(locator).isDisplayed();
    }

    protected boolean isSelected(By locator) {
        return waitForVisible(locator).isSelected();
    }

    protected boolean isEnabled(By locator) {
        return waitForVisible(locator).isEnabled();
    }

    protected String attributeOf(By locator, String attributeName) {
        return waitForVisible(locator).getAttribute(attributeName);
    }

    protected void selectByVisibleText(By locator, String visibleText) {
        new Select(waitForVisible(locator)).selectByVisibleText(visibleText);
        pauseForDemo();
    }

    protected List<WebElement> selectOptions(By locator) {
        return new Select(waitForVisible(locator)).getOptions();
    }

    protected String selectedOptionText(By locator) {
        return new Select(waitForVisible(locator)).getFirstSelectedOption().getText().trim();
    }

    protected void hover(By locator) {
        new Actions(driver).moveToElement(waitForVisible(locator)).perform();
        pauseForDemo();
    }

    protected Alert waitForAlert() {
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert() {
        waitForAlert().accept();
        pauseForDemo();
    }

    protected void dismissAlert() {
        waitForAlert().dismiss();
        pauseForDemo();
    }

    protected void enterTextAndAcceptAlert(String value) {
        Alert alert = waitForAlert();
        alert.sendKeys(value);
        alert.accept();
        pauseForDemo();
    }

    protected boolean imageIsBroken(WebElement image) {
        Object result = ((JavascriptExecutor) driver)
                .executeScript("return arguments[0].complete && arguments[0].naturalWidth === 0;", image);
        return Boolean.TRUE.equals(result);
    }

    protected WebElement waitWithFluentPolling(By locator) {
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(ConfigReader.getTimeoutSeconds()))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(org.openqa.selenium.NoSuchElementException.class)
                .until(webDriver -> {
                    WebElement element = webDriver.findElement(locator);
                    return element.isDisplayed() ? element : null;
                });
    }

    private void pauseForDemo() {
        int delayMillis = ConfigReader.getDemoDelayMillis();
        if (delayMillis <= 0) {
            return;
        }

        long endTime = System.currentTimeMillis() + delayMillis;
        new WebDriverWait(driver, Duration.ofMillis(delayMillis + 500L))
                .pollingEvery(Duration.ofMillis(100))
                .until(webDriver -> System.currentTimeMillis() >= endTime);
    }
}
