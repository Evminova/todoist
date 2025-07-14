package com.todoist.api;
import com.github.javafaker.Faker;

public class PasswordRecovery {

    public PasswordRecovery() {
    }

    private static final Faker faker = new Faker();
    private static final String CORRECT_SYMBOLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String genetareCorrectEmail ( int partMin, int partMax){
         String part = faker.regexify("[a-zA-Z0-9]{" + partMin + "," + partMax + "}");

         return part + "@gmail.com";
    }

    public static class AuthRequest {
        public String email;

        public AuthRequest(String email) {
            this.email = email;
        }
    }
}
