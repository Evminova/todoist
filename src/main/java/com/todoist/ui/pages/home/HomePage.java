package com.todoist.ui.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.todoist.ui.pages.home.HomeLocators.*;

public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(ENTER_BUTTON)));
        loginButton.click();
    }

    public void checkLoginPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("auth/login"));

        WebElement loginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(LOGIN_FORM))
        );

        Assert.assertEquals(loginHeader.getText(), "Log in");
    }

    public void clickStartFreeButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startFreeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(SIGNUP_BUTTON)));
        startFreeButton.click();
    }

    public void checkSignUpPageOpened() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("auth/signup"));

        WebElement signUpHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(SIGNUP_FORM)
        ));

        Assert.assertEquals(signUpHeader.getText(),"Sign up");
    }
}
