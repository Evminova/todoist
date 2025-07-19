package com.todoist.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("Config.properties")) {
            if (input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Не найден файл Config.properties в resources");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValidEmail() {
        return properties.getProperty("valid.email");
    }

    public static String getValidPassword() {
        return properties.getProperty("valid.password");
    }
}
