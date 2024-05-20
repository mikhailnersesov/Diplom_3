package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.steps;

import org.openqa.selenium.WebDriver;
import ru.praktikum.stellarburgers.nomoreparties.ui.atlas.pages.LoginPage;
import ru.praktikum.stellarburgers.nomoreparties.ui.atlas.pages.MainPage;

public final class MainPageSteps extends BasePageSteps<MainPage> {
    public MainPageSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected MainPage onPage() {
        return open(MainPage.class);
    }

    public MainPageSteps clickStellarBurgerLogoTab() {
        onPage().header().stellarBurgersLogo().click();
        return this;
    }
    public MainPageSteps clickSpecificHeaderTab(String tabTypeName) {
        onPage().header().specificTab(tabTypeName).click();
        return this;
    }
}
