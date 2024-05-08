package ru.praktikum.stellarburgers.nomoreparties;

import org.junit.Assert;
import org.junit.Test;

public class RegistrationTests extends BaseTest {
    @Test
    public void registerWithCorrectDataSuccessfully() {
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName()
                .enterEmail()
                .enterPassword()
                .clickRegisterButton()
                .enterEmail()
                .enterPassword()
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
}
