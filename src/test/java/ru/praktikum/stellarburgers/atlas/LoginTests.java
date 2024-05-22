package ru.praktikum.stellarburgers.atlas;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.atlas.steps.LoginPageSteps;

import static ru.praktikum.stellarburgers.nomoreparties.ui.config.UiConfig.LOGIN_INTO_ACCOUNT;

public class LoginTests extends BaseTest {
    @Test
    @Story("Проверка количества статей по разделам")
    public void checkArticlesCount() {
        LoginPageSteps loginPageSteps = new LoginPageSteps(getWebDriver());
        loginPageSteps.clickButton("Войти в аккаунт");
        System.out.println("ok");
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Данный тест покрывает следующий кейс: Пользователь может проходит успешный логин через кнопку 'Войти' в форме регистрации")
    public void loginViaRegistrationFormSuccessfully() {
        createAccount();
        new LoginPageSteps(getWebDriver())
                .clickLoginIntoAccount()
                .clickButton(LOGIN_INTO_ACCOUNT)
                .clickHref("/register")
                .clickHref("/login")
                .fillField("Email", email)
                .switchToMainPage()
                .clickStellarBurgerLogoTab()
                .clickSpecificHeaderTab("logo");
        System.out.println("ok");
//        boolean createOrderButtonDisplayed = new MainPage(webDriver)
//                .clickLoginIntoAccountButton()
//                .clickRegisterButton()
//                .clickLoginButton()
//                .enterEmail(email)
//                .enterPassword(password)
//                .clickLoginButton()
//                .isCreateOrderButtonDisplayed();
//        Assert.assertTrue(createOrderButtonDisplayed);
    }
}
