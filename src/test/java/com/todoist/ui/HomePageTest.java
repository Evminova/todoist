package com.todoist.ui;

import com.todoist.ui.pages.BaseUI;
import com.todoist.ui.pages.home.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseUI {

    @Test
    public void testEnterToLoginPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        homePage.checkLoginPageOpened();
    }

    @Test
    public void testEnterToSignUpPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickStartFreeButton();
        homePage.checkSignUpPageOpened();
    }
}
