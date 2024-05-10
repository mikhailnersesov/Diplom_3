package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        webDriverWait.until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return createOrderButton.isDisplayed();
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

    @Step("Проверка выделена ли вкладка 'Соусы' как активная")
    @SneakyThrows
    public boolean isSauceTabSelected() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 15);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentTabSauceTab));
        try {
            return currentTabSauceTab.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(1000);
            return currentTabSauceTab.isDisplayed();
        }
    }

    @Step("Нажатие вкладки 'Булки' на главной странице")
    public MainPage clickBunTab() {
        bunTab.click();
        return this;
    }

    @Step("Проверка выделена ли вкладка 'Булки' как активная")
    public boolean isBunTabSelected() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentTabBunTab));
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
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentTabFillingTab));
        try {
            return currentTabFillingTab.isDisplayed();
        } catch (NoSuchElementException e) {
            Thread.sleep(1000);
            return currentTabFillingTab.isDisplayed();
        }
    }
}
