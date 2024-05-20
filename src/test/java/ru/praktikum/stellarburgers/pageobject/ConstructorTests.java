package ru.praktikum.stellarburgers.pageobject;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.praktikum.stellarburgers.nomoreparties.ui.pageobject.MainPage;

@RunWith(Parameterized.class)
public class ConstructorTests extends BaseTest {
    @Parameterized.Parameter(0)
    public String firstTabToClickName;
    @Parameterized.Parameter(1)
    public String tabUnderTestName;

    @Parameterized.Parameters(name = "{index} - firstTabToClickName {0},tabUnderTestName {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Fillings", "Sauces"},
                {"Sauces", "Fillings"},
                {"Fillings", "Buns"},
        };
    }
    @Test
    @DisplayName("Успешный переход в в раздел '{tabName}'")
    @Description("Данный тест покрывает следующий кейс: неавторизованный пользователь может открыть раздел '{tabName}' и раздел показан как активный")
    public void switchToSpecificTabSuccessfully() {
        boolean specificTabSelected = new MainPage(webDriver)
                .clickSpecificTab(firstTabToClickName)
                .clickSpecificTab(tabUnderTestName)
                .isSpecificTabSelected(tabUnderTestName);
        Assert.assertTrue(specificTabSelected);
    }
}
