package com.todoist.api;

import com.todoist.driver.BaseAPI;
import com.todoist.utils.LoginDataGenerator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PasswordRecoveryRequestTest extends BaseAPI {

    private static final String RECOVERY_ENDPOINT = "/auth/password";

    @Test
    public void testRecoveryWithValidEmail() {
        PasswordRecoveryRequest request = new PasswordRecoveryRequest(
                LoginDataGenerator.getYourEmail()
        );

        given()
                .body(request)
                .when()
                .post(RECOVERY_ENDPOINT)
                .then()
                .statusCode(200)
                .body("message", equalTo("Recovery email sent"))
                .log().all();
    }

    @Test
    public void testRecoveryWithInvalidEmail() {
        PasswordRecoveryRequest request = new PasswordRecoveryRequest(
                LoginDataGenerator.generateInvalidEmail()
        );

        given()
                .body(request)
                .when()
                .post(RECOVERY_ENDPOINT)
                .then()
                .statusCode(400)
                .body("error", equalTo("Invalid email format"))
                .log().all();
    }

    @Test
    public void testRecoveryWithRandomEmail() {
        PasswordRecoveryRequest request = new PasswordRecoveryRequest(
                LoginDataGenerator.generateValidEmail(5, 10)
        );

        given()
                .body(request)
                .when()
                .post(RECOVERY_ENDPOINT)
                .then()
                .statusCode(404)
                .body("error", equalTo("User not found"))
                .log().all();
    }
}
