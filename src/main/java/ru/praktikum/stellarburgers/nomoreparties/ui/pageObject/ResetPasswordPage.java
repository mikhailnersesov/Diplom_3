package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordPage extends BasePage {
    @FindBy(xpath = "//*[@href='/login']")
    private WebElement loginButton;

    public ResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажатие кнопки 'Войти' на странице восстановления пароля, с переходом на страницу логина")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(webDriver);
    }
}
