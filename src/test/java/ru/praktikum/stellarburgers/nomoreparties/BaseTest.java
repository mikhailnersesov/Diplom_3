package ru.praktikum.stellarburgers.nomoreparties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.stellarburgers.nomoreparties.api.client.UserClient;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserCreateRequest;
import ru.praktikum.stellarburgers.nomoreparties.api.step.UserSteps;

import java.util.ArrayList;
import java.util.List;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static ru.praktikum.stellarburgers.nomoreparties.ui.config.ConfigsUi.BASE_URI;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.email;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.password;
import static ru.praktikum.stellarburgers.nomoreparties.ui.pageObject.BasePage.name;

public abstract class BaseTest {
    protected WebDriver webDriver;
    protected static UserSteps userSteps;
    protected String userToken;
    protected static List<String> userTokens = new ArrayList();

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
                WebDriverManager.chromedriver().setup();
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
        } catch (AssertionError assertionError) {
            System.out.println("no users was created - nothing to save");
        }
        userTokens.add(userToken);
    }
    @AfterClass
    public static void tearDownAll(){
        for (String token : userTokens) {
            if (token != null) {
                userSteps.deleteUserRequest(token).statusCode(SC_ACCEPTED).body("message", is("User successfully removed"));
            }
        }
    }

    // Методы
    public void openWebPage() {
        // переход на страницу тестового приложения
        webDriver.get(BASE_URI);
    }
}
