package com.todoist.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest {

    public static final String BASE_URL = "https://app.todoist.com/api/v9.223";

    @Test
    public void testLoginWithInvalidPassword() {
        String email = LoginPage.genetareCorrectEmail(5, 10);
        String password = LoginPage.generateCorrectPassword(8, 12);

        given()
                .header("Content-Type", "application/json")
                .body(String.format("{\"email\": \"%s\", \"password\": \"%s\"}", email, password))
                .when()
                .post(BASE_URL + "/user/login")
                .then()
                .statusCode(401);
    }
}
