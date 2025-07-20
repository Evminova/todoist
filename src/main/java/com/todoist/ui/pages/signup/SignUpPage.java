package com.todoist.ui.pages.signup;

import com.todoist.ui.pages.BaseUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.todoist.ui.pages.signup.SignUpLocators.*;

public class SignUpPage {
    private final WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(INPUT_FIELD_EMAIL_SIGNUP)));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath(INPUT_FIELD_PASSWORD_SIGNUP));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmitSignUpButton() {
        WebElement submitSignUpButton = driver.findElement(By.xpath(BUTTON_SUBMIT_SIGNUP));
        submitSignUpButton.click();
    }

    public void submitSignUpForm(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSubmitSignUpButton();
    }
    public boolean isInvalidEmailMessageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath(SIGN_UP_ERROR_MESSAGE)));
            return errorMessage.isDisplayed();
    }
}
