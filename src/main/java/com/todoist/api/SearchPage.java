package com.todoist.api;

import static io.restassured.RestAssured.given;

public class SearchPage {

    public String makeSearchBoby(String query) {
        return given()
                .queryParam("query", query)
                .when()
                .get("https://todoist.zendesk.com/api/v2/help_center/articles/search/ru")
                .then()
                .extract()
                .response()
                .body()
                .asString();
    }
}
