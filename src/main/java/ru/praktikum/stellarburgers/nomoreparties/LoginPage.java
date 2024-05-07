package ru.praktikum.stellarburgers.nomoreparties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends BasePage {
    @FindBy(xpath = "//*[@name='name']")
    private WebElement emailField;
    protected LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public LoginPage enterEmail() {
        emailField.sendKeys("1234");
        return this;
    }
}
