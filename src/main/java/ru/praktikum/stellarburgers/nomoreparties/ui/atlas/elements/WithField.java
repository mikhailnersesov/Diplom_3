package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.elements;

import io.qameta.atlas.webdriver.extension.FindBy;
import io.qameta.atlas.webdriver.extension.Param;


public interface WithField {
    @FindBy("//label[@class='input__placeholder text noselect text_type_main-default'][normalize-space()='{{ placeholder }}']//following-sibling::input")
    Field field(@Param("placeholder") String placeholderText);
}
