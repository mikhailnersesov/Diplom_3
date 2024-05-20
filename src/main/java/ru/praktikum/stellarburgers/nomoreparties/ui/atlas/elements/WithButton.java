package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.elements;

import io.qameta.atlas.webdriver.AtlasWebElement;
import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;

public interface WithButton {
    @FindBy(".//button[normalize-space()='{{ buttonText }}']")
    AtlasWebElement button(@Param("buttonText") String buttonText);
    @FindBy(".//*[@href='{{ hrefText }}']")
    AtlasWebElement href(@Param("hrefText") String hrefText);
}
