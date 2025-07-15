package com.todoist.ui;

import com.todoist.driver.BaseUI;
import com.todoist.ui.home.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseUI {

    @Test
    public void testEnterToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.checkLoginPageOpened();
    }
}
