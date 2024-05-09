package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ResetPasswordPage extends BasePage {
    @FindBy(xpath = "//label[normalize-space()='Email']")
    private WebElement emailField;
    @FindBy(xpath = "//button[normalize-space()='Восстановить']")
    private WebElement recoverButton;
    @FindBy(xpath = "//label[normalize-space()='Введите код из письма']")
    private WebElement mailCodeField;
    @FindBy(xpath = "//*[@name='Пароль']")
    private WebElement passwordField;
    @FindBy(xpath = "//*[@name='Сохранить']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@href='/login']")
    private WebElement loginButton;

    public ResetPasswordPage(WebDriver webDriver) {
        super(webDriver);
    }
    public ResetPasswordPage enterEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }
    public ResetPasswordPage clickRecoverButton() {
        recoverButton.click();
        return this;
    }
    public ResetPasswordPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }
    public ResetPasswordPage clickSaveButton() {
        saveButton.click();
        return this;
    }
    public ResetPasswordPage enterMailCode(String email) {
        mailCodeField.sendKeys(email);
        return this;
    }
    public LoginPage clickLoginButton() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage(webDriver);
    }
}
