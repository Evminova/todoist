package com.todoist.driver;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseUI {
    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.createDriver();
        driver.get("https://todoist.com/ru");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
