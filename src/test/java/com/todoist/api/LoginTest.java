package com.todoist.api;

import com.todoist.utils.LoginDataGenerator;
import com.todoist.utils.Config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginTest extends BaseAPI {

    private static final String LOGIN_ENDPOINT = "/user/login";

    @Test
    public void testInvalidPassword() {
        String randomEmail = LoginDataGenerator.generateValidEmail(5, 8);
        String invalidPassword = LoginDataGenerator.generatePassword(8, 15);

        LoginModelAPI loginModelAPI = new LoginModelAPI(randomEmail, invalidPassword);

        given()
                .body(loginModelAPI)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(401)
                .log().all();
    }

    @Test
    public void testInvalidEmailFormat() {
        String invalidEmail = LoginDataGenerator.generateInvalidEmail();
        String password = LoginDataGenerator.generatePassword(8, 15);

        LoginModelAPI loginModelAPI = new LoginModelAPI(invalidEmail, password);

        given()
                .body(loginModelAPI)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(400)
                .body("error", equalTo("Email is invalid"))
                .log().all();
    }

    @Test
    public void testEmptyEmail() {
        String emptyEmail = "";
        String password = LoginDataGenerator.generatePassword(8, 15);

        LoginModelAPI loginModelAPI = new LoginModelAPI(emptyEmail, password);

        given()
                .body(loginModelAPI)
                .when()
                .post(LOGIN_ENDPOINT)
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
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(400)
                .body("error", equalTo("Required argument is missing"))
                .log().all();
    }

    @Test
    public void testValidEmailValidPassword() {
        LoginModelAPI request = new LoginModelAPI(
                Config.getValidEmail(),
                Config.getValidPassword()
        );

        given()
                .body(request)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testValidEmailInvalidPassword() {
        String validEmail = Config.getValidEmail();
        String invalidPassword = LoginDataGenerator.generatePassword(8, 15);

        LoginModelAPI loginModelAPI = new LoginModelAPI(validEmail, invalidPassword);

        given()
                .body(loginModelAPI)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(401)
                .body("error", equalTo("Wrong email or password"))
                .log().all();
    }
}
