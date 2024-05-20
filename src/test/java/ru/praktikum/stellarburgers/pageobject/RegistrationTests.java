package ru.praktikum.stellarburgers.pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageobject.MainPage;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация")
    @Description("Данный тест покрывает следующий кейс: пользователя можно успешно создать, заполнив все обязательные поля (имя, почта и пароль)")
    public void registerWithCorrectDataSuccessfully() {
        boolean loginButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .clickRegisterButton()
                .switchToLoginPage()
                .isLoginButtonDisplayed();
        Assert.assertTrue(loginButtonDisplayed);
    }

    @Test
    @DisplayName("Ошибка для некорректного пароля. Минимальный пароль — шесть символов")
    @Description("Данный тест покрывает следующий кейс: пользователя нельзя создать с паролем из 5 символов")
    public void registerWith5LettersPasswordFailed() {
        password = RandomStringUtils.randomAlphabetic(5);
        boolean incorrectPasswordErrorMessageDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .clickRegisterButton()
                .isIncorrectPasswordErrorMessageDisplayed();
        Assert.assertTrue(incorrectPasswordErrorMessageDisplayed);
    }
}
