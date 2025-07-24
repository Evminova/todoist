package com.todoist.ui.pages;

import com.todoist.driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

public class BaseUI {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(Method method) {
        driver = Driver.getDriver();
        driver.manage().deleteAllCookies();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
