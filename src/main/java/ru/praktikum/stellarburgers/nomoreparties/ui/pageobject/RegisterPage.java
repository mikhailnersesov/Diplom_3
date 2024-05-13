package ru.praktikum.stellarburgers.nomoreparties.ui.pageobject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    @FindBy(xpath = "//*[normalize-space()='Имя']//following-sibling::*[@name='name']")
    private WebElement nameField;
    @FindBy(xpath = "//*[normalize-space()='Email']//following-sibling::*[@name='name']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@name='Пароль']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()='Зарегистрироваться']")
    private WebElement registerButton;
    @FindBy(xpath = "//*[normalize-space()='Некорректный пароль']")
    private WebElement incorrectPasswordErrorMessage;
    @FindBy(xpath = "//*[@href='/login']")
    private WebElement loginButton;

    public RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ввод имени '{name}' в поле 'Имя' на странице регистрации")
    public RegisterPage enterName(String name) {
        nameField.sendKeys(name);
        return this;
    }

    @Step("Ввод почты '{email}'в поле 'Email' на странице регистрации")
    public RegisterPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    @Step("Ввод пароля '{password}'в поле 'Пароль' на странице регистрации")
    public RegisterPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Нажатие кнопки 'Зарегистрироваться' на странице регистрации, с переходом на страницу логина")
    public LoginPage clickRegisterButtonSuccessfully() {
        registerButton.click();
        return new LoginPage(webDriver);
    }

    @Step("Нажатие кнопки 'Зарегистрироваться' на странице регистрации, оставаясь на странице регистрации")
    public RegisterPage clickRegisterButtonReturnsError() {
        registerButton.click();
        return this;
    }

    @Step("Проверка показано ли сообщение об ошибке 'Некорректный пароль'")
    public boolean isIncorrectPasswordErrorMessageDisplayed() {
        return incorrectPasswordErrorMessage.isDisplayed();
    }

    @Step("Нажатие кнопки 'Войти' на странице регистрации, с переходом на страницу логина")
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(webDriver);
    }
}
