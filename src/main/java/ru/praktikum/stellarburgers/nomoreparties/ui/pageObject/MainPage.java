package ru.praktikum.stellarburgers.nomoreparties.ui.pageObject;

import io.qameta.allure.Step;
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
    @Step("Click the 'Login into account' button on the Main Page")
    public LoginPage clickLoginIntoAccountButton() {
        loginIntoAccountButton.click();
        return new LoginPage(webDriver);
    }
    public boolean isCreateOrderButtonDisplayed(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(createOrderButton));
        return createOrderButton.isDisplayed();
    }
    public LoginPage clickUnsecureProfileButton() {
        profileButton.click();
        return new LoginPage(webDriver);
    }
    public ProfilePage clickSecureProfileButton() {
        profileButton.click();
        return new ProfilePage(webDriver);
    }
    public MainPage clickSauceTab() {
        sauceTab.click();
        return this;
    }
    public boolean isSauceTabSelected(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentTabSauceTab));
        return currentTabSauceTab.isDisplayed();
    }
    public MainPage clickBunTab() {
        bunTab.click();
        return this;
    }
    public boolean isBunTabSelected(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentTabBunTab));
        return currentTabBunTab.isDisplayed();
    }
    public MainPage clickFillingTab() {
        fillingTab.click();
        return this;
    }
    public boolean isFillingTabSelected(){
        webDriverWait.until(ExpectedConditions.elementToBeClickable(currentTabFillingTab));
        return currentTabFillingTab.isDisplayed();
    }
}
