package com.todoist.driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.createDriver();
        driver.get("https://todoist.com/ru");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
