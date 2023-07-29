package com.example.PersonalFinanceAPI.application.dto.response;

import com.example.PersonalFinanceAPI.domain.models.User;

public class FindUserResponseDto {
    private String status;
    private String message;
    private User user;
    public FindUserResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
    public FindUserResponseDto(String status, String message, User user) {
        this.status = status;
        this.message = message;
        this.user = user;
    }

    public FindUserResponseDto() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
