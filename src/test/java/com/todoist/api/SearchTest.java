package com.todoist.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SearchTest {

    @Test
    public void testSearch() {
        String search = "Запрос возврата средств";
        SearchPage searchPage = new SearchPage();
        String body = searchPage.makeSearchBoby(search);

        Assert.assertTrue(body.contains(search),search);
    }
}
