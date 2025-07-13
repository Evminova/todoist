package com.todoist.api;

import com.todoist.driver.BaseAPI;
import com.todoist.utils.AuthDataGenerator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginTest extends BaseAPI {

    @Test
    public void testLoginWithInvalidPassword() {
        LoginPage.AuthRequest authRequest = new LoginPage.AuthRequest(
                AuthDataGenerator.generateEmail(5,10),
                "wrong_password");

        given()
                .body(authRequest)
                .when()
                .post("/user/login")
                .then()
                .statusCode(401)
                .log().all();
    }
}
