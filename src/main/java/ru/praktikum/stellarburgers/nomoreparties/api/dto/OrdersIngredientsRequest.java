package ru.praktikum.stellarburgers.nomoreparties.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersIngredientsRequest {
    private ArrayList<String> ingredients;
}
