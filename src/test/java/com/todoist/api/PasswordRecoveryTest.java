package com.todoist.api;

import com.todoist.driver.BaseAPI;
import com.todoist.utils.AuthDataGenerator;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PasswordRecoveryTest extends BaseAPI {

    @Test
    public void testRecoveryWithWrongEmail() {
        String randomEmail = AuthDataGenerator.generateEmail(5, 10);

        given()
                .queryParam("email", randomEmail)
                .when()
                .post("/auth/password")
                .then()
                .statusCode(400)
                .log().all();
    }
}
