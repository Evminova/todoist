package com.todoist.api;

import com.todoist.driver.BaseAPI;
import com.todoist.utils.LoginDataGenerator;
import com.todoist.utils.Config;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginTestAPI extends BaseAPI {

    private static final String LOGIN_ENDPOINT = "/user/login";

    @Test
    public void testInvalidPassword() {
        String randomEmail = LoginDataGenerator.generateValidEmail(5, 8);
        String invalidPassword = LoginDataGenerator.generatePassword(8, 15);

        LoginPageAPI loginPageAPI = new LoginPageAPI(randomEmail, invalidPassword);

        given()
                .body(loginPageAPI)
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

        LoginPageAPI loginPageAPI = new LoginPageAPI(invalidEmail, password);

        given()
                .body(loginPageAPI)
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

        LoginPageAPI loginPageAPI = new LoginPageAPI(emptyEmail, password);

        given()
                .body(loginPageAPI)
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
        LoginPageAPI request = new LoginPageAPI(
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

        LoginPageAPI loginPageAPI = new LoginPageAPI(validEmail, invalidPassword);

        given()
                .body(loginPageAPI)
                .when()
                .post(LOGIN_ENDPOINT)
                .then()
                .statusCode(401)
                .body("error", equalTo("Wrong email or password"))
                .log().all();
    }
}
