package ru.praktikum.stellarburgers.nomoreparties.selenium.selenide;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.page;


public class LoginTests extends BaseTest {
    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Данный тест покрывает следующий кейс: Пользователь может проходит успешный логин через кнопку 'Войти' в форме регистрации")
    public void loginViaRegistrationFormSuccessfully() {
        createAccount();
        // создаём экземпляр класса главной страницы
        MainPage mainPage = page(MainPage.class);
        mainPage.clickLoginIntoAccountButton();
    }


}
