package com.internetbot.utils;

import com.internetbot.driver.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {
    private static final Path SCREENSHOT_DIR = Path.of("screenshots");
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS");

    private ScreenshotUtil() {
    }

    public static String capture(String testName) {
        try {
            Files.createDirectories(SCREENSHOT_DIR);
            Path screenshotPath = SCREENSHOT_DIR.resolve(testName + "_" + LocalDateTime.now().format(FORMATTER) + ".png");
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
            Files.write(screenshotPath, screenshot);
            return screenshotPath.toAbsolutePath().toString();
        } catch (IOException | RuntimeException exception) {
            return "";
        }
    }
}
