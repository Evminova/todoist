package com.todoist.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SearchTest {

    @Test
    public void testSearch() {
        given()
                .when()
                .get("https://todoist.zendesk.com/api/v2/help_center/articles/search?query=Запрос возврата средств&locale=ru")
                .then()
                .log().all();
    }
}
