package ru.praktikum.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserCreateRequest;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.MainPage;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
    public void registerWithCorrectDataSuccessfully() {
        boolean loginButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName()
                .enterEmail()
                .enterPassword()
                .clickRegisterButton()
                .isLoginButtonDisplayed();
        Assert.assertTrue(loginButtonDisplayed);
    }
    @Test
    @DisplayName("Успешная регистрация")
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
    public void registerWithCorrectDataSuccessfully2() {
        boolean loginButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName()
                .enterEmail()
                .enterPassword()
                .clickRegisterButton()
                .isLoginButtonDisplayed();
        Assert.assertTrue(loginButtonDisplayed);
    }
}
