package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Path;

public class FileUploadPage extends BasePage {
    private final By heading = By.cssSelector("h3");
    private final By fileInput = By.id("file-upload");
    private final By uploadButton = By.id("file-submit");
    private final By uploadSuccessHeading = By.cssSelector("h3");
    private final By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.upload");
    }

    public boolean isUploadFormVisible() {
        return isDisplayed(fileInput) && isDisplayed(uploadButton);
    }

    public boolean isFileInputVisible() {
        return isDisplayed(fileInput);
    }

    public boolean isUploadButtonVisible() {
        return isDisplayed(uploadButton);
    }

    public boolean isUploadButtonEnabled() {
        return isEnabled(uploadButton);
    }

    public String getHeading() {
        return textOf(heading);
    }

    public void upload(Path filePath) {
        waitForVisible(fileInput).sendKeys(filePath.toAbsolutePath().toString());
        click(uploadButton);
    }

    public String getUploadedFileName() {
        return textOf(uploadedFiles);
    }

    public String getUploadSuccessHeading() {
        return textOf(uploadSuccessHeading);
    }
}
