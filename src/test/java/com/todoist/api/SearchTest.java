package com.todoist.api;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchTest {

    @Test
    public void testSearch() {
        String search = "Product updates";
        SearchPage searchPage = new SearchPage();
        String body = String.valueOf(searchPage.makeSearchBody(search));

        Assert.assertTrue(body.contains(search),"Response body should contain search query: " + search);
    }
}
