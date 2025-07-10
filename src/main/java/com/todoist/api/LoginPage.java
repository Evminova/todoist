package com.todoist.api;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


public class LoginPage {

    @Test
    public void testLogin() {
        given()
                .header("Content-Type", "application/json")
                .body("{\"email\": \"test@test.com\", \"password\": \"qwerty123\"}")
                .when().post("https://app.todoist.com/api/v9.223/user/login")
                .then().log().all();
    }
}
