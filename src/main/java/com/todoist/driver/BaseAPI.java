package com.todoist.driver;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseAPI {

    @BeforeSuite
    public void setUp() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://app.todoist.com")
                .setBasePath("/api/v9.223")
                .addHeader("Content-Type", "application/json")
                .build();
    }

    @AfterSuite
    public void tearDown() {
        RestAssured.reset();
    }
}
