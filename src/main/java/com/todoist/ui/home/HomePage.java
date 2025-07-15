package com.todoist.ui.home;

import com.todoist.driver.BaseUI;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.todoist.ui.home.HomeLocators.ENTER_BUTTON;
import static com.todoist.ui.home.HomeLocators.LOGIN_FORM;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath(ENTER_BUTTON));
        loginButton.click();
    }

    public void checkLoginPageOpened() {
        WebElement loginHeader = driver.findElement(By.xpath(LOGIN_FORM));
        Assertions.assertEquals("Войти", loginHeader.getText());
    }
}
