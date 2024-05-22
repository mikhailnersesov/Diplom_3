package ru.praktikum.stellarburgers.nomoreparties.selenium.plain;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.selenium.plain.ui.pageobject.MainPage;

public class ProfileTests extends BaseTest {
    @Test
    @DisplayName("Успешный переход в личный кабинет по клику на «Личный кабинет»")
    @Description("Данный тест покрывает следующий кейс: авторизованный пользователь может открыть Личный кабинет с домашней страницы")
    public void openProfileSuccessfully() {
        createAccount();
        boolean logoutButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .clickSecureProfileButton()
                .isLogoutButtonDisplayed();
        Assert.assertTrue(logoutButtonDisplayed);
    }

    @Test
    @DisplayName("Успешный переход из личного кабинета по клику на «Конструктор»")
    @Description("Данный тест покрывает следующий кейс: авторизованный пользователь может открыть Конструктор из личного кабинета")
    public void openConstructorFromProfileSuccessfully() {
        createAccount();
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .clickSecureProfileButton()
                .clickConstructorButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }

    @Test
    @DisplayName("Успешный выход из аккаунта по кнопке «Выйти» в личном кабинете")
    @Description("Данный тест покрывает следующий кейс: авторизованный пользователь может выйти из аккаунта нажав кнопку 'Выйти' в личном кабинете")
    public void logoutFromProfileSuccessfully() {
        createAccount();
        boolean loginButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .clickSecureProfileButton()
                .clickLogoutButton()
                .isLoginButtonDisplayed();
        Assert.assertTrue(loginButtonDisplayed);
    }


}
