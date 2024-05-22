package ru.praktikum.stellarburgers.nomoreparties.selenium.selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends BasePage {
//    @FindBy(xpath = "//label[normalize-space()='Email']//following-sibling::*")
//    private WebElement emailField;
//    @FindBy(xpath = "//*[@name='Пароль']")
//    private WebElement passwordField;
//    @FindBy(xpath = "//*[@href='/register']")
//    private WebElement registerButton;
    @FindBy(how = How.XPATH, using = "//*[@href='/register']")
    private SelenideElement registerButton;

//    @FindBy(xpath = "//button[normalize-space()='Войти']")
//    private WebElement loginButton;
//    @FindBy(xpath = "//*[@href='/forgot-password']")
//    private WebElement forgotPasswordButton;
//

//
//    @Step("Ввод почты '{email}' в поле 'Email' на странице логина")
//    public LoginPage enterEmail(String email) {
//        emailField.sendKeys(email);
//        return this;
//    }
//
//    @Step("Ввод пароля '{password}' в поле 'Пароль' на странице логина")
//    public LoginPage enterPassword(String password) {
//        passwordField.sendKeys(password);
//        return this;
//    }
//
    @Step("Нажатие кнопки 'Зарегистрироваться' на странице логина, с переходом на страницу регистрации")
    public LoginPage clickRegisterButton() {
        registerButton.click(); // uses the implicite wait from BaseTest
        return page(LoginPage.class);
    }
//
//    @Step("Нажатие кнопки 'Войти' на странице логина, с переходом на главную страницу")
//    public ru.praktikum.stellarburgers.nomoreparties.selenium.plain.ui.pageobject.MainPage clickLoginButton() {
//        loginButton.click();
//        return new MainPage(webDriver);
//    }
//
//    @Step("Проверка можно ли нажать на кнопку 'Войти' на странице логина")
//    public boolean isLoginButtonDisplayed() {
//        return loginButton.isDisplayed();
//    }
//
//    @Step("Нажатие кнопки 'Восстановить пароль' на странице логина, с переходом на страницу восстановления пароля")
//    public ResetPasswordPage clickRecoverPasswordButton() {
//        forgotPasswordButton.click();
//        return new ResetPasswordPage(webDriver);
//    }
}
