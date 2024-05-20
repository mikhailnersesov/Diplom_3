package ru.praktikum.stellarburgers.nomoreparties.ui.atlas.steps;

import io.qameta.allure.Step;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.openqa.selenium.WebDriver;
import ru.praktikum.stellarburgers.nomoreparties.ui.atlas.pages.BasePage;
import static ru.yandex.qatools.matchers.webdriver.DisplayedMatcher.displayed;

public abstract class BasePageSteps <Page extends BasePage> {
    protected final WebDriver webDriver;
    private final Atlas atlas;

    BasePageSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.atlas = new Atlas(new WebDriverConfiguration(webDriver));
    }
    protected abstract Page onPage();
    protected Page open(Class<Page> page) {
        return atlas.create(webDriver, page);
    }
    @Step("Кликнуть по кнопке {buttonTitle}")
    public <T extends BasePageSteps> T clickButton(String buttonTitle) {
        onPage().button(buttonTitle).waitUntil("Кнопка " + buttonTitle + " не отобразилась", displayed(), 30).click();
        return (T) this;
    }
    @Step("Кликнуть по ссылке {hrefTitle}")
    public <T extends BasePageSteps> T clickHref(String hrefTitle) {
        onPage().href(hrefTitle).waitUntil("Кнопка " + hrefTitle + " не отобразилась", displayed(), 30).click();
        return (T) this;
    }
    @Step("Заполнить поле '{fieldTitle}' значением '{value}'")
    public <T extends BasePageSteps> T fillField(String fieldTitle, String value) {
        onPage().field(fieldTitle).sendKeys(value);
        return (T) this;
    }

    public MainPageSteps switchToMainPage() {
        return new MainPageSteps(webDriver);
    }
}
