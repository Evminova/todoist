package com.todoist.api;

public class LoginPageRequest {
    public String email;
    public String password;

    public LoginPageRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
