package com.todoist.api;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class LoginPage {

    public LoginPage() {
    }

    private static final Faker faker = new Faker();
    private static final String CORRECT_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String genetareCorrectEmail(int partMin, int partMax) {
        String part = faker.regexify("[a-zA-Z0-9]{" + partMin + "," + partMax + "}");

        return part + "@gmail.com";
    }

    public static String generateCorrectPassword(int minLength, int maxLength) {
        return faker.regexify("[a-zA-Z0-9!@#$%^&*]{" + minLength + "," + maxLength + "}");
    }
}
