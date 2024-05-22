package ru.praktikum.stellarburgers.nomoreparties.ui.atlas;

import java.util.Properties;

public class Xpath {
    public Xpath(Properties properties) {
        this.properties = properties;
    }

    public static Properties properties;
    public static final String email = "//input[starts-with(@id,'email_address')]";
    public static final String password = "//input[starts-with(@id,'password')]";
    public static final String password2 = properties.getProperty("test");

}
