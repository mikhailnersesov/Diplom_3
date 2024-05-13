package ru.praktikum.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageobject.MainPage;

public class ConstructorTests extends BaseTest {
    @Test
    @DisplayName("Успешный переход в в раздел 'Соусы'")
    @Description("Данный тест покрывает следующий кейс: неавторизованный пользователь может открыть раздел 'Соусы' и раздел показан как активный")
    public void switchToSaucesTabSuccessfully() {
        boolean saucesTabSelected = new MainPage(webDriver)
                .clickSauceTab()
                .loginIntoAccountButtonIsDisplayed()
                .isSauceTabSelected();
        Assert.assertTrue(saucesTabSelected);
    }

    @Test
    @DisplayName("Успешный переход в в раздел 'Булки'")
    @Description("Данный тест покрывает следующий кейс: неавторизованный пользователь может открыть раздел 'Булки' и раздел показан как активный")
    public void switchToBunsTabSuccessfully() {
        boolean bunsTabSelected = new MainPage(webDriver)
                .clickSauceTab()
                .loginIntoAccountButtonIsDisplayed()
                .clickBunTab()
                .isBunTabSelected();
        Assert.assertTrue(bunsTabSelected);
    }

    @Test
    @DisplayName("Успешный переход в в раздел 'Начинки'")
    @Description("Данный тест покрывает следующий кейс: неавторизованный пользователь может открыть раздел 'Начинки' и раздел показан как активный")
    public void switchToFillingsTabSuccessfully() {
        boolean fillingsTabSelected = new MainPage(webDriver)
                .clickFillingTab()
                .isFillingTabSelected();
        Assert.assertTrue(fillingsTabSelected);
    }
}
