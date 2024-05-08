package ru.praktikum.stellarburgers.nomoreparties.api.dto;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateRequest {
    private String email;
    private String password;
    private String name;
}
