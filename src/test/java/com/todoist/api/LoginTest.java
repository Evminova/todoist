package com.todoist.api;

import com.todoist.driver.BaseAPI;
import com.todoist.utils.AuthDataGenerator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseAPI {

    @Test
    public void testLoginWithInvalidPassword() {
        String randomEmail = AuthDataGenerator.generateEmail(5,10);
        String invalidPassword = AuthDataGenerator.generatePassword(8,12);

        LoginPage.AuthRequest authRequest = new LoginPage.AuthRequest(randomEmail, invalidPassword);

        given()
                .body(authRequest)
                .when()
                .post("/user/login")
                .then()
                .statusCode(401)
                .log().all();
    }
}
