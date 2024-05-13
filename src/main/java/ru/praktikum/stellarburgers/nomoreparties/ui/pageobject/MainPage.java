package ru.praktikum.stellarburgers.nomoreparties.ui.pageobject;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    @FindBy(xpath = "//*[text()='Войти в аккаунт']")
    private WebElement loginIntoAccountButton;
    @FindBy(xpath = "//button[normalize-space()='Оформить заказ']")
    private WebElement createOrderButton;
    @FindBy(xpath = "//*[@href='/account']")
    private WebElement profileButton;
    @FindBy(xpath = "//*[contains(@class, 'tab')][normalize-space()='Соусы']")
    private WebElement sauceTab;
    @FindBy(xpath = "//*[contains(@class, 'tab')][normalize-space()='Булки']")
    private WebElement bunTab;
    @FindBy(xpath = "//*[contains(@class, 'tab')][normalize-space()='Начинки']")
    private WebElement fillingTab;
    @FindBy(xpath = "//*[contains(@class, 'tab_tab_type_current')][normalize-space()='Булки']")
    private WebElement currentTabBunTab;
    @FindBy(xpath = "//*[contains(@class, 'tab_tab_type_current')][normalize-space()='Соусы']")
    private WebElement currentTabSauceTab;
    @FindBy(xpath = "//*[contains(@class, 'tab_tab_type_current')][normalize-space()='Начинки']")
    private WebElement currentTabFillingTab;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Нажатие кнопки 'Войти в аккаунт' на главной странице, с переходом на страницу логина")
    public LoginPage clickLoginIntoAccountButton() {
        loginIntoAccountButton.click();
        return new LoginPage(webDriver);
    }

    @Step("Проверка можно ли нажать на кнопку 'Оформить заказ' на главной странице")
    public boolean isCreateOrderButtonDisplayed() {
        return createOrderButton.isDisplayed();
    }

    @Step("Проверка кнопка 'Войти в аккаунт' присутствует на главной странице")
    public MainPage loginIntoAccountButtonIsDisplayed() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(loginIntoAccountButton));
        loginIntoAccountButton.isDisplayed();
        return this;
    }

    @Step("Нажатие кнопки 'Личный кабинет' на главной странице, без предварительного логина с переходом на страницу логина")
    public LoginPage clickUnsecureProfileButton() {
        profileButton.click();
        return new LoginPage(webDriver);
    }

    @Step("Нажатие кнопки 'Личный кабинет' на главной странице, залогиненным пользователем с переходом на страницу личного кабинета")
    public ProfilePage clickSecureProfileButton() {
        profileButton.click();
        return new ProfilePage(webDriver);
    }

    @Step("Нажатие вкладки 'Соусы' на главной странице")
    public MainPage clickSauceTab() {
        sauceTab.click();
        return this;
    }

    @Step("Нажатие вкладки '{tabName}' на главной странице")
    public MainPage clickSpecificTab(String tabName) {
        switch (tabName) {
            case "Sauces":
                webDriverWait.until(ExpectedConditions.elementToBeClickable(sauceTab));
                sauceTab.click();
                break;
            case "Buns":
                webDriverWait.until(ExpectedConditions.elementToBeClickable(bunTab));

                bunTab.click();
                break;
            case "Fillings":
                webDriverWait.until(ExpectedConditions.elementToBeClickable(fillingTab));

                fillingTab.click();
                break;
        }
        return this;
    }

    @Step("Проверка выделена ли вкладка 'Соусы' как активная")
    @SneakyThrows
    public boolean isSauceTabSelected() {
        return currentTabSauceTab.isDisplayed();
    }

    @Step("Нажатие вкладки 'Булки' на главной странице")
    public MainPage clickBunTab() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(bunTab));
        bunTab.click();
        return this;
    }

    @Step("Проверка выделена ли вкладка 'Булки' как активная")
    public boolean isBunTabSelected() {
        return currentTabBunTab.isDisplayed();
    }

    @Step("Нажатие вкладки 'Начинки' на главной странице")
    public MainPage clickFillingTab() {
        fillingTab.click();
        return this;
    }

    @Step("Проверка выделена ли вкладка 'Начинки' как активная")
    @SneakyThrows
    public boolean isFillingTabSelected() {
        return currentTabFillingTab.isDisplayed();
    }

    @Step("Проверка выделена ли вкладка 'Начинки' как активная")
    @SneakyThrows
    public boolean isSpecificTabSelected(String tabName) {
        switch (tabName) {
            case "Sauces":
                return currentTabSauceTab.isDisplayed();
            case "Buns":
                return currentTabBunTab.isDisplayed();
            case "Fillings":
                return currentTabFillingTab.isDisplayed();
        }
        return false;
    }
}
