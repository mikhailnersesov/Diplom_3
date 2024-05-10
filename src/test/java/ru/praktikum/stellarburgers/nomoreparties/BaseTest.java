package ru.praktikum.stellarburgers.nomoreparties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.stellarburgers.nomoreparties.api.client.UserClient;
import ru.praktikum.stellarburgers.nomoreparties.api.step.UserSteps;

import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static ru.praktikum.stellarburgers.nomoreparties.ui.config.UiConfig.BASE_URI;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.*;

public abstract class BaseTest {
    protected WebDriver webDriver;
    protected static UserSteps userSteps;
    protected String userToken;
    protected static List<String> userTokens = new ArrayList();
    static int i = 0;

    @AfterClass
    public static void tearDownAll(){
        for (String token : userTokens) {
            if (token != null) {
                System.out.println("Deletion of the usern " + i + " token: " + token);
                userSteps.deleteUserRequest(token).statusCode(SC_ACCEPTED).body("message", is("User successfully removed")).log().all();
                i++;

            }
        }
        userTokens.clear();
    }

    @Before
    public void setup() {
        email = "test-data@yandex" + RandomStringUtils.randomAlphabetic(5) + ".ru";
        password = RandomStringUtils.randomAlphabetic(6);
        name = RandomStringUtils.randomAlphabetic(5);
        userSteps = new UserSteps(new UserClient());
        switch (String.valueOf(System.getProperty("browser"))) {
            case "yandex":
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
                this.webDriver = new ChromeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().clearDriverCache().setup();
                this.webDriver = new ChromeDriver();
        }
        openWebPage();
    }

    @After
    public void tearDown() {
        // закрытие браузера
        webDriver.quit();
        try {
            String accessToken = userSteps.loginUserRequest(email, password).statusCode(SC_OK).extract().path("accessToken");
            int spaceIndex = accessToken.indexOf(" "); // Find the index of the space character
            userToken = accessToken.substring(spaceIndex + 1);  // Extract the second part of the string using substring
            userTokens.add(userToken);
        } catch (AssertionError assertionError) {
            System.out.println("no users was created - nothing to save");
        }
    }

    // Методы
    public void openWebPage() {
        // переход на страницу тестового приложения
        webDriver.get(BASE_URI);
    }
}
