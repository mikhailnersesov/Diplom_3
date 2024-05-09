package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[text()='Войти в аккаунт']")
    private WebElement loginIntoAccountButton;

    @FindBy(xpath = "//button[normalize-space()='Оформить заказ']")
    private WebElement createOrderButton;
    @FindBy(xpath = "//*[@href='/account']")
    private WebElement profileButton;
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Step("Click the 'Login into account' button on the Main Page")
    public LoginPage clickLoginIntoAccountButton() {
        loginIntoAccountButton.click();
        return new LoginPage(webDriver);
    }
    public boolean isCreateOrderButtonDisplayed(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return createOrderButton.isDisplayed();
    }
    public LoginPage clickUnsecureProfileButton() {
        profileButton.click();
        return new LoginPage(webDriver);
    }
    public ProfilePage clickSecureProfileButton() {
        profileButton.click();
        return new ProfilePage(webDriver);
    }
}
