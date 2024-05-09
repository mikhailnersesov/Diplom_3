package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage {
    @FindBy(xpath = "//button[normalize-space()='Выход']")
    private WebElement logoutButton;
    @FindBy(xpath = "//li[normalize-space()='Конструктор']")
    private WebElement constructorButton;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isLogoutButtonDisplayed() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        return logoutButton.isDisplayed();
    }
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return new MainPage(webDriver);
    }
    public LoginPage clickLogoutButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();
        return new LoginPage(webDriver);
    }
}
