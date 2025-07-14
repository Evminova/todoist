package com.todoist.utils;

import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    public static String getValidEmail() {
        return properties.getProperty("valid.email");
    }

    public static String getValidPassword() {
        return properties.getProperty("valid.password");
    }
}
