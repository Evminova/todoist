package com.todoist.ui.pages.login;

public class LoginLocators {
    public static final String INPUT_FIELD_EMAIL = "//input[@autocomplete=\"email\"]";
    public static final String INPUT_FIELD_PASSWORD = "//input[@autocomplete=\"current-password\"]";
    public static final String BUTTON_SUBMIT = "//button[@type=\"submit\"]";
    public static final String ERROR_MESSAGE = "//div[text()='Неверный Email или пароль.']";
    public static final String LINK_REGISTRATION = "//a[@href=\"/auth/signup\"]";
    public static final String TEXT_REGISTRATION = "//h1[text()='Регистрация']";

}
