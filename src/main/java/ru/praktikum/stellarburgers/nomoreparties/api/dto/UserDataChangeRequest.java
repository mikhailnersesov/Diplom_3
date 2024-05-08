package ru.praktikum.stellarburgers.nomoreparties.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataChangeRequest {
    private String email;
    private String name;
}
