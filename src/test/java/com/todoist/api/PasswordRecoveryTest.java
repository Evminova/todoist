package com.todoist.api;

import com.todoist.utils.Config;
import com.todoist.utils.LoginDataGenerator;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PasswordRecoveryTest extends BaseAPI {

    private static final String RECOVERY_ENDPOINT = "/Users/sendResetPassword";

    @BeforeMethod
    public void setUpRecovery() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://app.todoist.com")
                .setBasePath("")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @Test
    public void testRecoveryWithValidEmail() {
        PasswordRecoveryAPI request = new PasswordRecoveryAPI(Config.getValidEmail());

        given()
                .body(request)
                .when()
                .post(RECOVERY_ENDPOINT)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testRecoveryWithInvalidEmail() {
        PasswordRecoveryAPI request = new PasswordRecoveryAPI(
                LoginDataGenerator.generateInvalidEmail()
        );

        given()
                .body(request)
                .when()
                .post(RECOVERY_ENDPOINT)
                .then()
                .statusCode(400)
                .log().all();
    }

    @Test
    public void testRecoveryWithRandomEmail() {
        PasswordRecoveryAPI request = new PasswordRecoveryAPI(
                LoginDataGenerator.generateValidEmail(5, 10)
        );

        given()
                .body(request)
                .when()
                .post(RECOVERY_ENDPOINT)
                .then()
                .statusCode(400)
                .log().all();
    }
}
