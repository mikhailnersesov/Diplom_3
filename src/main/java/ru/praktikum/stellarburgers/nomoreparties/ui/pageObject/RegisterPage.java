package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import org.apache.commons.lang3.RandomStringUtils;
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

//    String name = RandomStringUtils.randomAlphabetic(5);
//    static String email = "test-data@yandex" + RandomStringUtils.randomAlphabetic(5) + ".ru";
//    static String password = RandomStringUtils.randomAlphabetic(6);
    protected RegisterPage(WebDriver webDriver) {
        super(webDriver);
    }
    public RegisterPage enterName() {
        nameField.sendKeys(name);
        return this;
    }
    public RegisterPage enterEmail() {
        emailField.sendKeys(email);
        return this;
    }
    public RegisterPage enterPassword() {
        passwordField.sendKeys(password);
        return this;
    }
    public LoginPage clickRegisterButton() {
        registerButton.click();
        return new LoginPage(webDriver);
    }
}
