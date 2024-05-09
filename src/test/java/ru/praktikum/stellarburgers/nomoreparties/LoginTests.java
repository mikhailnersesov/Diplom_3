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
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
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
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
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
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
    public void loginViaProfileSuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickProfileButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
    public void loginViaPasswordRecoverySuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickProfileButton()
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
                .statusCode(SC_OK) //BUG: STEBURG-1: actually is a bug in RQ: creation should be not 200, but "201 created"
                .body("success", is(true));
    }
}
