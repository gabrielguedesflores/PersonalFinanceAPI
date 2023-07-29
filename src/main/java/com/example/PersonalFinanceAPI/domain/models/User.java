package com.example.PersonalFinanceAPI.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("users")
public class User {
    @Id
    private String userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private Date userDateLastUpdated;

    public User() {
        // Nenhum argumento é necessário no construtor sem argumentos.
        // Você pode deixar vazio ou incluir alguma lógica adicional, se necessário.
    }
    public User(String userName, String userEmail, String userPassword, Date userDateLastUpdated) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDateLastUpdated = userDateLastUpdated;
    }

    public User(String userId, String userName, String userEmail, String userPassword, Date userDateLastUpdated) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userDateLastUpdated = userDateLastUpdated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
