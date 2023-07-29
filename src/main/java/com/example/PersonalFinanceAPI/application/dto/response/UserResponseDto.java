package com.example.PersonalFinanceAPI.application.dto.response;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class UserResponseDto {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private Date userDateLastUpdated;

    // Construtor com os campos desejados para o POST
    public UserResponseDto(String userName, String userEmail, Date userDateLastUpdated) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userDateLastUpdated = userDateLastUpdated;
    }

    // Getters e setters
    // ...
}
