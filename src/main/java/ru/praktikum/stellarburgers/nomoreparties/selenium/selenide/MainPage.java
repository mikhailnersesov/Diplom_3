package ru.praktikum.stellarburgers.nomoreparties.selenium.selenide;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class MainPage extends BasePage {
    @FindBy(how = How.XPATH, using = "//*[text()='Войти в аккаунт']")
    private SelenideElement loginIntoAccountButton;

    public MainPage() {
    }

    @Step("Нажатие кнопки 'Войти в аккаунт' на главной странице, с переходом на страницу логина")
    public MainPage clickLoginIntoAccountButton() {
        loginIntoAccountButton.click();
        return this;
    }
    public LoginPage switchToLoginPage() {
        return page(LoginPage.class);
    }

}
