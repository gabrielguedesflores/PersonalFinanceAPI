package com.example.PersonalFinanceAPI.domain.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document("expenses")
public class Expense {

    @Id
    private String id;
    private String userId;
    private String description;
    private double amount;
    private Date date;
    private List<String> tags;

    public Expense(String userId, String description, double amount, Date date, List<String> tags) {
        this.userId = userId;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.tags = tags;
    }

    // Getters e Setters (gerados pelo Lombok)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
