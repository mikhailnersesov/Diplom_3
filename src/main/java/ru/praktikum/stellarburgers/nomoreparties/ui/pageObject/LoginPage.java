package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//label[normalize-space()='Email']//following-sibling::*")
    private WebElement emailField;
    @FindBy(xpath = "//*[@name='Пароль']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@href='/register']")
    private WebElement registerButton;

    @FindBy(xpath = "//button[normalize-space()='Войти']")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@href='/forgot-password']")
    private WebElement forgotPasswordButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки 'Зарегистрироваться' на странице логина, с переходом на страницу регистрации")
    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return new RegisterPage(webDriver);
    }

    @Step("Нажатие кнопки 'Войти' на странице логина, с переходом на главную страницу")
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(webDriver);
    }

    @Step("Проверка можно ли нажать на кнопку 'Войти' на странице логина")
    public boolean isLoginButtonDisplayed() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return loginButton.isDisplayed();
    }

    @Step("Нажатие кнопки 'Восстановить пароль' на странице логина, с переходом на страницу восстановления пароля")
    public ResetPasswordPage clickRecoverPasswordButton() {
        forgotPasswordButton.click();
        return new ResetPasswordPage(webDriver);
    }
}
