package ru.praktikum.stellarburgers.nomoreparties.selenium.plain.ui.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage {
    @FindBy(xpath = "//button[normalize-space()='Выход']")
    private WebElement logoutButton;
    @FindBy(xpath = "//li[normalize-space()='Конструктор']")
    private WebElement constructorButton;

    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Проверка можно ли нажать на кнопку 'Выход' на личного кабинета")
    public boolean isLogoutButtonDisplayed() {
        return logoutButton.isDisplayed();
    }

    @Step("Нажатие кнопки 'Конструктор' на странице логина, с переходом на главную страницу")
    public MainPage clickConstructorButton() {
        constructorButton.click();
        return new MainPage(webDriver);
    }

    @Step("Нажатие кнопки 'Выход' на странице личного кабинета, с переходом на страницу логина")
    public LoginPage clickLogoutButton() {
        logoutButton.click();
        return new LoginPage(webDriver);
    }
}
