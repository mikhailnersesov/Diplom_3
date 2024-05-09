package ru.praktikum.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.MainPage;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.RegisterPage;

import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.*;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя можно создать; 2) чтобы создать пользователя, нужно заполнить все обязательные поля; 3) при успешной регистрации происходит переход на страницу логина; 4) отображается кнопка войти")
    public void registerWithCorrectDataSuccessfully() {
        boolean loginButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .clickRegisterButton()
                .isLoginButtonDisplayed();
        Assert.assertTrue(loginButtonDisplayed);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    @Description("Данный тест покрывает следующие кейсы: 1) пользователя нельзя создать, 2) для создания пользователя нужно указать минимиу ")
    public void registerWith5LettersPasswordFailed() {
        password = RandomStringUtils.randomAlphabetic(5);
        new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .clickRegisterButton();
        boolean incorrectPasswordErrorMessagenDisplayed = new RegisterPage(webDriver)
                .isIncorrectPasswordErrorMessageDisplayed();
        Assert.assertTrue(incorrectPasswordErrorMessagenDisplayed);
    }
}
