package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.RegisterPage.email;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.RegisterPage.password;

public class LoginPage  extends BasePage {
    @FindBy(xpath = "//*[@name='name']")
    private WebElement emailField;
    @FindBy(xpath = "//*[@name='Пароль']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@href='/register']")
    private WebElement registerButton;
    @FindBy(xpath = "//button[normalize-space()='Войти']")
    private WebElement loginButton;

    protected LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginPage enterEmail() {
        emailField.sendKeys(email);
        return this;
    }
    public LoginPage enterPassword() {
        passwordField.sendKeys(password);
        return this;
    }
    public RegisterPage clickRegisterButton() {
        registerButton.click();
        return new RegisterPage(webDriver);
    }
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(webDriver);
    }
    public boolean isLoginButtonDisplayed(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        return loginButton.isDisplayed();
    }
}
