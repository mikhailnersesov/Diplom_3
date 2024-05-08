package ru.praktikum.stellarburgers.nomoreparties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[text()='Войти в аккаунт']")
    private WebElement loginIntoAccountButton;

    @FindBy(xpath = "//button[normalize-space()='Оформить заказ']")
    private WebElement createOrderButton;
    protected MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginPage clickLoginIntoAccountButton() {
        loginIntoAccountButton.click();
        return new LoginPage(webDriver);
    }
    public MainPage test(){
        return this;
    }
    public boolean isCreateOrderButtonDisplayed(){
        return createOrderButton.isDisplayed();
    }
}
