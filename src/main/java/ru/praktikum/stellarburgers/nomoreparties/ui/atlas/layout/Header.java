package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.layout;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface Header extends AtlasWebElement {
    @FindBy("//*[contains(@class,'AppHeader_header__logo')]")
    AtlasWebElement stellarBurgersLogo();
    @FindBy("//*[contains(@class,'AppHeader_header__{{ tabType }}')]")
    Header specificTab(@Param("tabType") String tabTypeName);

}
