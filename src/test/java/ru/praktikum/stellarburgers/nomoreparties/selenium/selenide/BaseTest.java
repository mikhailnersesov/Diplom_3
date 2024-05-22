package ru.praktikum.stellarburgers.nomoreparties.selenium.selenide;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.datafaker.Faker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.stellarburgers.nomoreparties.api.client.UserClient;
import ru.praktikum.stellarburgers.nomoreparties.api.step.UserSteps;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.is;
import static ru.praktikum.stellarburgers.nomoreparties.selenium.plain.ui.config.UiConfig.BASE_URI;

public abstract class BaseTest {
    private static UserSteps userSteps;
    private static List<String> userTokens = new ArrayList();
    private final Faker faker = new Faker();
    protected WebDriver webDriver;
    protected String userToken;
    protected String name;
    protected String email;
    protected String password;

    @AfterClass
    public static void tearDownAll() {
        for (String token : userTokens) {
            if (token != null) {
                userSteps.deleteUserRequest(token).statusCode(SC_ACCEPTED).body("message", is("User successfully removed"));
            }
        }
        userTokens.clear();
    }

    @Before
    public void setup() {
        email = faker.internet().emailAddress();
        password = faker.internet().password(6, 12);
        name = faker.name().lastName();

        userSteps = new UserSteps(new UserClient());
        openWebPage();
    }

    @After
    public void tearDown() {
        try {
            String accessToken = userSteps.loginUserRequest(email, password).statusCode(SC_OK).extract().path("accessToken");
            int spaceIndex = accessToken.indexOf(" ");
            userToken = accessToken.substring(spaceIndex + 1);
            userTokens.add(userToken);
        } catch (AssertionError assertionError) {
            System.out.println("no users was created - nothing to save");
        }
    }

    public void openWebPage() {
        open(BASE_URI);
    }
    protected void createAccount() {
        userSteps
                .createUserRequest(email, password, name)
                .statusCode(SC_OK)
                .body("success", is(true));
    }
}
