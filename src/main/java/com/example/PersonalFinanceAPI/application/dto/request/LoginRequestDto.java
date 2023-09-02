package com.example.PersonalFinanceAPI.application.dto.request;

public class LoginRequestDto {
    private String userEmail;
    private String userPassword;

    public LoginRequestDto(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public LoginRequestDto() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
