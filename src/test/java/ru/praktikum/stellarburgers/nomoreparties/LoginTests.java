package ru.praktikum.stellarburgers.nomoreparties;

import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.MainPage;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.email;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.password;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.name;

public class LoginTests  extends BaseTest {
    @Test
    public void registerWithCorrectDataSuccessfully() {
        boolean createOrderButtonDisplayed = new MainPage(webDriver)
                .clickLoginIntoAccountButton()
                .clickRegisterButton()
                .enterName(name)
                .enterEmail(email)
                .enterPassword(password)
                .clickRegisterButton()
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginButton()
                .isCreateOrderButtonDisplayed();
        Assert.assertTrue(createOrderButtonDisplayed);
    }
}
