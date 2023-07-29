package com.example.PersonalFinanceAPI.application.dto.request;

import java.util.Date;
import java.util.List;

public class ExpenseRequestDto {
    private String userId;
    private String description;
    private double amount;
    private Date date;
    private List<String> tags;
    public ExpenseRequestDto() {}
    public ExpenseRequestDto(String userId, String description, double amount, Date date, List<String> tags) {
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.tags = tags;
    }

    // Getters e Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
