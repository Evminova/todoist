package com.todoist.api;

import com.todoist.driver.BaseAPI;
import com.todoist.utils.AuthDataGenerator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginTest extends BaseAPI {

    @Test
    public void testInvalidPassword() {
        String randomEmail = AuthDataGenerator.generateEmail(5, 10);
        String invalidPassword = AuthDataGenerator.generatePassword(8, 15);

        LoginPage.AuthRequest authRequest = new LoginPage.AuthRequest(randomEmail, invalidPassword);

        given()
                .body(authRequest)
                .when()
                .post("/user/login")
                .then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void testInvalidEmailFormat() {
        String invalidEmail = AuthDataGenerator.generateInvalidEmail();
        String password = AuthDataGenerator.generatePassword(8, 15);

        LoginPage.AuthRequest authRequest = new LoginPage.AuthRequest(invalidEmail, password);

        given()
                .body(authRequest)
                .when()
                .post("/user/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Email is invalid"))
                .log().all();
    }

    @Test
    public void testEmptyEmail() {
        String emptyEmail = "";
        String password = AuthDataGenerator.generatePassword(8, 15);

        LoginPage.AuthRequest authRequest = new LoginPage.AuthRequest(emptyEmail, password);

        given()
                .body(authRequest)
                .when()
                .post("/user/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Email is invalid"))
                .log().all();
    }

    @Test
    public void testNullEmailPassword() {
        String nullEmail = null;
        String nullPassword = null;

        given()
                .when()
                .post("/user/login")
                .then()
                .statusCode(400)
                .body("error", equalTo("Required argument is missing"))
                .log().all();
    }
}
