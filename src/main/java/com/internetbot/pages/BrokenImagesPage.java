package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BrokenImagesPage extends BasePage {
    private final By images = By.cssSelector(".example img");

    public BrokenImagesPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.broken.images");
    }

    public long countBrokenImages() {
        return waitForAllVisible(images).stream()
                .filter(this::imageIsBroken)
                .count();
    }

    public boolean hasAtLeastOneWorkingImage() {
        return waitForAllVisible(images).stream()
                .anyMatch(image -> !imageIsBroken(image));
    }

    public int getImageCount() {
        return waitForAllVisible(images).size();
    }
}
