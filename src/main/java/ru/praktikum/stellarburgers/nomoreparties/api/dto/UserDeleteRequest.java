package ru.praktikum.stellarburgers.nomoreparties.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDeleteRequest {
    private String accessToken;
}
