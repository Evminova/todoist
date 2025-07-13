package com.todoist.utils;

import com.github.javafaker.Faker;

public class AuthDataGenerator {
    private static final Faker faker = new Faker();

    public static String generateEmail(int localPartMin, int localPartMax) {
        return faker.regexify("[a-z0-9]{" + localPartMin + "," + localPartMax + "}") + "@gmail.com";
    }

    public static String generatePassword(int minLength, int maxLength) {
        return faker.regexify("[A-Za-z0-9!@#$%]{" + minLength + "," + maxLength + "}");
    }

    public static String generateInvalidEmail() {
        return "invalid" + faker.random().nextInt(100) + "@gmail";
    }
}
