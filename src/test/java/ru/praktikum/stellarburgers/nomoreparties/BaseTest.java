package ru.praktikum.stellarburgers.nomoreparties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public abstract class BaseTest {
    protected WebDriver webDriver;

    @Before
    public void setup() {
        switch (String.valueOf(System.getProperty("browser"))) {
            case "yandex":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                this.webDriver = new ChromeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                this.webDriver = new ChromeDriver();
        }
        openWebPage();
    }

    @After
    public void tearDown() {
        // закрытие браузера
        webDriver.quit();
    }

    // Методы
    public void openWebPage() {
        // переход на страницу тестового приложения
        webDriver.get("https://stellarburgers.nomoreparties.site/");
    }
}
