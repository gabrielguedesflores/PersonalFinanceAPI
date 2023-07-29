package com.example.PersonalFinanceAPI.application.dto.request;

import java.util.Date;

public class UserRequestDto {
    private String userName;
    private String userEmail;
    private String userPassword;
    private Date userDateLastUpdated;
    public UserRequestDto() {
    }
    public UserRequestDto(String userName, String userEmail, String userPassword, Date userDateLastUpdated) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDateLastUpdated = userDateLastUpdated;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Date getUserDateLastUpdated() {
        return userDateLastUpdated;
    }

    public void setUserDateLastUpdated(Date userDateLastUpdated) {
        this.userDateLastUpdated = userDateLastUpdated;
    }
}
