package ru.praktikum.stellarburgers.nomoreparties.api.client;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserCreateRequest;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserLoginRequest;

import static ru.praktikum.stellarburgers.nomoreparties.api.config.UserConfig.*;

public class UserClient extends RestClient {
    @Step("Send POST request to /auth/register")
    public Response sendPostRequestUserRegister(UserCreateRequest userCreateRequest) {
        return getdefaultRequestSpecification()
                .body(userCreateRequest)
                .when()
                .post(REGISTER_ENDPOINT);
    }

    @Step("Send POST request to /auth/login")
    public Response sendPostRequestUserLogin(UserLoginRequest userLoginRequest) {
        return getdefaultRequestSpecification()
                .body(userLoginRequest)
                .when()
                .post(LOGIN_ENDPOINT);
    }

    @Step("Send DELETE request to /auth/user")
    public Response sendDeleteRequestUserDeletion(String accessToken) {
        return getdefaultRequestSpecification().auth().oauth2(accessToken)
                .when()
                .delete(DELETE_ENDPOINT);
    }

    @Step("Send PATCH request to /auth/user")
    public Response sendPatchRequestGetUserData(String accessToken) {
        return sendPatchRequestGetUserData(null);
    }

}
