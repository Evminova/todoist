package com.todoist.api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchPage {

    public Response makeSearchBody(String query) {
        return given()
                .baseUri("https://todoist.zendesk.com")
                .basePath("/api/v2/help_center/articles/search")
                .queryParam("query", query)
                .queryParam("locale", "en-us")
                .header("referer", "https://www.todoist.com/")
                .header("accept", "*/*")
                .when()
                .get()
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .response();
    }
}
