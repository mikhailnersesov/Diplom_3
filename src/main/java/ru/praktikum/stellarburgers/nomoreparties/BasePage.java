package ru.praktikum.stellarburgers.nomoreparties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected final WebDriver webDriver;
    protected final WebDriverWait webDriverWait;

    protected BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 3);
        PageFactory.initElements(webDriver,this);
    }
}
