package com.example.PersonalFinanceAPI.models;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("expenses")
public class Expense {

    @Id
    private String id;
    private String userId;
    private String description;
    private double amount;

    public Expense() {
    }

    public Expense(String id, String userId, String description, double amount) {
        this.id = id;
        this.userId = userId;
        this.description = description;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }
}