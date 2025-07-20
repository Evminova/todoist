package com.todoist.ui.pages.login;

import com.todoist.ui.pages.BaseUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.todoist.ui.pages.login.LoginLocators.*;

public class LoginPageUI extends BaseUI {

    public LoginPageUI(WebDriver driver) {
        this.driver = driver;
    }

    public void getEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FIELD_EMAIL)));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void getPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath(INPUT_FIELD_PASSWORD));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.xpath(BUTTON_SUBMIT));
        submitButton.click();
    }

    public void login(String email, String password) {
        getEmail(email);
        getPassword(password);
        clickSubmitButton();
    }

    public boolean isEmailInvalid() {
        WebElement emailField = driver.findElement(By.xpath(INPUT_FIELD_EMAIL));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        return !(Boolean) js.executeScript("return arguments[0].checkValidity();", emailField);
    }

    public String getEmailValidationMessage() {
        WebElement emailField = driver.findElement(By.xpath(INPUT_FIELD_EMAIL));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        return (String) js.executeScript("return arguments[0].validationMessage;", emailField);
    }

    public boolean isPasswordInvalid() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessageEmptyPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(ERROR_MESSAGE_WRONG_PASSWORD)));
        return errorMessageEmptyPassword.isDisplayed();
    }
}
