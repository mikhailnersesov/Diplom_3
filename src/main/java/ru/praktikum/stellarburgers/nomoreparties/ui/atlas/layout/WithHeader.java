package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.layout;

import io.qameta.atlas.webdriver.extension.FindBy;

public interface WithHeader {
    @FindBy("//header[contains(@class,'Header')]")
    Header header();
}
