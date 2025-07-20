package com.todoist.ui;

import com.todoist.ui.pages.BaseUI;
import com.todoist.ui.pages.home.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTest extends BaseUI {

    @Test
    public void testEnterToLoginPage() {
        driver.get("https://todoist.com");
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("auth/login"));
    }

    @Test
    public void testEnterToSignUpPage() {
        driver.get("https://todoist.com");
        HomePage homePage = new HomePage(driver);
        homePage.clickStartFreeButton();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("auth/signup"));
    }
}
