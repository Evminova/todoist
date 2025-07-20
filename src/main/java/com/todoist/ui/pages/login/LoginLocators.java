package com.todoist.ui.pages.login;

public class LoginLocators {
    public static final String INPUT_FIELD_EMAIL = "//input[@autocomplete=\"email\"]";
    public static final String INPUT_FIELD_PASSWORD = "//input[@autocomplete=\"current-password\"]";
    public static final String BUTTON_SUBMIT = "//button[@type=\"submit\"]";
    public static final String ERROR_MESSAGE = "//div[text()='Wrong email or password.']";
    public static final String ERROR_MESSAGE_WRONG_PASSWORD = "//p[text()='Passwords must be at least 8 characters long.']";
    public static final String LINK_REGISTRATION = "//a[@href=\"/auth/signup\"]";
    public static final String TEXT_REGISTRATION = "//h1[text()='Регистрация']";

}
