package ru.praktikum.stellarburgers.nomoreparties.api.step;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import ru.praktikum.stellarburgers.nomoreparties.api.client.UserClient;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserCreateRequest;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserDataChangeRequest;
import ru.praktikum.stellarburgers.nomoreparties.api.dto.UserLoginRequest;

public class UserSteps {
    private final UserClient userClient;

    public UserSteps(UserClient userClient) {
        this.userClient = userClient;
    }
    @Step("Создание уникального пользователя")
    public ValidatableResponse createUserRequest(String email, String password, String name) {
        UserCreateRequest userCreateRequest = new UserCreateRequest();
        userCreateRequest.setEmail(email);
        userCreateRequest.setPassword(password);
        userCreateRequest.setName(name);
        return userClient.sendPostRequestUserRegister(userCreateRequest).then();
    }
@Step("Авторизация пользователя")
    public ValidatableResponse loginUserRequest(String email, String password) {
    UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setEmail(email);
        userLoginRequest.setPassword(password);
        return userClient.sendPostRequestUserLogin(userLoginRequest).then();
    }
    @Step("Удаление пользователя")
    public ValidatableResponse deleteUserRequest(String accessToken) {
        return userClient.sendDeleteRequestUserDeletion(accessToken).then();
    }
    @Step("Изменение данных пользователя")
    public ValidatableResponse getUserDataRequest(String email, String name, String accessToken) {
        UserDataChangeRequest userDataChangeRequest = new UserDataChangeRequest();
        userDataChangeRequest.setEmail(email);
        userDataChangeRequest.setName(name);
        return userClient.sendPatchRequestGetUserData(userDataChangeRequest,accessToken).then();
    }
    @Step("Восстановление и сброс пароля")
    public ValidatableResponse postPasswordRecoveryRequest(String email) {
        UserDataChangeRequest userDataChangeRequest = new UserDataChangeRequest();
        userDataChangeRequest.setEmail(email);
        return userClient.sendPostRequestRecoverPassword(userDataChangeRequest).then().log().all();
    }
}
