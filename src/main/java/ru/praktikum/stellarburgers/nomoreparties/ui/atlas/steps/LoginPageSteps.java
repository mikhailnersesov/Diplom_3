package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.steps;

import org.openqa.selenium.WebDriver;
import ru.praktikum.stellarburgers.nomoreparties.ui.atlas.pages.LoginPage;

public final class LoginPageSteps extends BasePageSteps<LoginPage> {
    public LoginPageSteps(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected LoginPage onPage() {
        return open(LoginPage.class);
    }

//    //TODO move to MainPage
//    public LoginPageSteps clickStellarBurgerLogoTab() {
//        onPage().header().stellarBurgersLogo().click();
//        return this;
//    }
//    public LoginPageSteps clickSpecificHeaderTab(String tabTypeName) {
//        onPage().header().specificTab(tabTypeName).click();
//        return this;
//    }
}
