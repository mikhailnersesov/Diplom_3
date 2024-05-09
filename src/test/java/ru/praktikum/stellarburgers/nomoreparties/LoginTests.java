package ru.praktikum.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.MainPage;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.email;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.password;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.name;

public class LoginTests  extends BaseTest {
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Данный тест покрывает следующий кейс: Пользователь может проходит успешный логин через кнопку 'Войти' в форме регистрации")
    public void loginViaRegistrationFormSuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .clickLoginButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
    @Test
    @DisplayName("Вход по кнопке «Войти в аккаунт» на главной")
    @Description("Данный тест покрывает следующий кейс: Пользователь может проходит успешный логин через кнопку 'Войти в аккаунт' на главной странице")
    public void loginViaMainPageSuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
    @Test
    @DisplayName("Вход через кнопку «Личный кабинет»")
    @Description("Данный тест покрывает следующий кейс: Пользователь может проходит успешный логин через кнопку 'Личный Кабинет'")
    public void loginViaProfileSuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickUnsecureProfileButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Данный тест покрывает следующий кейс: Пользователь может проходит успешный логин через кнопку 'Войти' на странице восстановления пароля")
    public void loginViaPasswordRecoverySuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickUnsecureProfileButton()
                .clickRecoverPasswordButton()
                .clickLoginButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
    public void createAccount(){
        userSteps
                .createUserRequest(email, password, name)
                .statusCode(SC_OK)
                .body("success", is(true));
    }
}
