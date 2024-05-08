package ru.praktikum.stellarburgers.nomoreparties;

import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.MainPage;

public class LoginTests  extends BaseTest {
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
