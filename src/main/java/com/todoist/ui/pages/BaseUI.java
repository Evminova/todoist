package com.todoist.ui.pages;

import com.todoist.driver.Driver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        setRussianLanguage();
        driver.get("https://app.todoist.com/auth/login");
    }

    private void setRussianLanguage() {
        driver.get("https://app.todoist.com");
        driver.manage().addCookie(new Cookie("language", "ru"));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
