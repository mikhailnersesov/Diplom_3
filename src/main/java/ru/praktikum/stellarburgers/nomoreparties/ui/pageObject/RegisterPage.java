package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
    public RegisterPage enterName(String name) {
        nameField.sendKeys(name);
        return this;
    }
    public RegisterPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public RegisterPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickRegisterButton() {
        registerButton.click();
        return new LoginPage(webDriver);
    }
    public boolean isIncorrectPasswordErrorMessageDisplayed(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(incorrectPasswordErrorMessage));
        return incorrectPasswordErrorMessage.isDisplayed();
    }
    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(webDriver);
    }
}
