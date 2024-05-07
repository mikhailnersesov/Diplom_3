package ru.praktikum.stellarburgers.nomoreparties;

import org.junit.Test;

public class RegistrationTests extends BaseTest {
    @Test
    public void registerWithCorrectDataSuccessfully() {
        new MainPage(webDriver)
                .test()
                .clickLoginIntoAccountButton()
                .enterEmail();
    }
}
