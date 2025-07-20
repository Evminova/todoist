package com.todoist.ui;

import com.todoist.ui.pages.BaseUI;
import com.todoist.ui.pages.signup.SignUpPage;
import com.todoist.utils.Config;
import com.todoist.utils.LoginDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.todoist.ui.pages.signup.SignUpLocators.*;

public class SignUpTest extends BaseUI {

    @Test
    public void testSuccessSignUp() {
        driver.get("https://app.todoist.com/auth/signup");

        SignUpPage signUpPage = new SignUpPage(driver);
        String validEmail = LoginDataGenerator.generateValidEmail(5, 10);
        String validPassword = LoginDataGenerator.generatePassword(8, 12);

        signUpPage.submitSignUpForm(validEmail, validPassword);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement textSuccessSignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(CHECK_EMAIL_TEXT)));

        Assert.assertTrue(textSuccessSignUp.isDisplayed(), "Check your email");
    }

    @Test
    public void testExistingEmail() {
        driver.get("https://app.todoist.com/auth/signup");

        SignUpPage signUpPage = new SignUpPage(driver);
        String existingEmail = Config.getValidEmail();
        String existingPassword = Config.getValidPassword();

        signUpPage.submitSignUpForm(existingEmail, existingPassword);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement validationEmailText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(VALIDATION_EMAIL_TEXT)));

        Assert.assertTrue(validationEmailText.isDisplayed(),
                "Oh no, this email address is unavailable! Please try a different address.");
    }

    @Test
    public void testEmptyFieldsSignUp() {
        driver.get("https://app.todoist.com/auth/signup");

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.submitSignUpForm("", "");

        Assert.assertTrue(signUpPage.isInvalidEmailMessageVisible(), "Please enter a valid email address.");
    }
}
