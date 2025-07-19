package com.todoist.ui;

import com.todoist.ui.pages.BaseUI;
import com.todoist.ui.pages.login.LoginPageUI;
import com.todoist.utils.Config;
import com.todoist.utils.LoginDataGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.todoist.ui.pages.login.LoginLocators.*;

public class LoginPageTest extends BaseUI {

    @Test
    public void testValidLogin() {
        LoginPageUI loginPage = new LoginPageUI(driver);
        loginPage.login(Config.getValidEmail(), Config.getValidPassword());

        Assert.assertTrue(driver.getCurrentUrl().contains("/app"));
    }

    @Test
    public void testInvalidEmail() {
        LoginPageUI loginPage = new LoginPageUI(driver);
        loginPage.login(LoginDataGenerator.generateInvalidEmail(), Config.getValidPassword());

        Assert.assertTrue(loginPage.isEmailInvalid());
        String message = loginPage.getEmailValidationMessage();
        System.out.println("Validation message: " + message);

        Assert.assertTrue(message.contains("@"));
    }

    @Test
    public void testValidEmailInvalidPassword() {
        LoginPageUI loginPage = new LoginPageUI(driver);
        loginPage.login(Config.getValidEmail(),
                LoginDataGenerator.generatePassword(8,12));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ERROR_MESSAGE)));

        String actualErrorText = errorMessage.getText();
        String expectedErrorText = "Неверный Email или пароль.";
    }
}
