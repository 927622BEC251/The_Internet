package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisappearingElementsPage extends BasePage {
    private final By navigationLinks = By.cssSelector("ul li a");
    private final By homeLink = By.linkText("Home");
    private final By aboutLink = By.linkText("About");
    private final By contactUsLink = By.linkText("Contact Us");
    private final By galleryLink = By.linkText("Gallery");

    public DisappearingElementsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.disappearing.elements");
    }

    public boolean refreshUntilGalleryAppears(int attempts) {
        for (int attempt = 0; attempt < attempts; attempt++) {
            if (!driver.findElements(galleryLink).isEmpty()) {
                return true;
            }
            driver.navigate().refresh();
        }
        return !driver.findElements(galleryLink).isEmpty();
    }

    public int getNavigationLinkCount() {
        return findAll(navigationLinks).size();
    }

    public boolean isHomeLinkVisible() {
        return isDisplayed(homeLink);
    }

    public boolean isAboutLinkVisible() {
        return isDisplayed(aboutLink);
    }

    public boolean isContactUsLinkVisible() {
        return isDisplayed(contactUsLink);
    }
}
