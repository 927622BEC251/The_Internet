package com.internetbot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HoverPage extends BasePage {
    private final By figures = By.cssSelector(".figure");
    private final By firstFigure = By.cssSelector(".figure:nth-of-type(1)");
    private final By secondFigure = By.cssSelector(".figure:nth-of-type(2)");
    private final By thirdFigure = By.cssSelector(".figure:nth-of-type(3)");
    private final By firstCaption = By.cssSelector(".figure:nth-of-type(1) .figcaption h5");
    private final By secondCaption = By.cssSelector(".figure:nth-of-type(2) .figcaption h5");
    private final By thirdCaption = By.cssSelector(".figure:nth-of-type(3) .figcaption h5");

    public HoverPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        openPath("path.hovers");
    }

    public String hoverFirstProfileAndGetName() {
        hover(firstFigure);
        return textOf(firstCaption).replace("name: ", "").trim();
    }

    public String hoverSecondProfileAndGetName() {
        hover(secondFigure);
        return textOf(secondCaption).replace("name: ", "").trim();
    }

    public String hoverThirdProfileAndGetName() {
        hover(thirdFigure);
        return textOf(thirdCaption).replace("name: ", "").trim();
    }

    public int getFigureCount() {
        return findAll(figures).size();
    }
}
