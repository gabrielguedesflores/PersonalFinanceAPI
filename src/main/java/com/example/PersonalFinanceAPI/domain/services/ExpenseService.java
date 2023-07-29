package com.example.PersonalFinanceAPI.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PersonalFinanceAPI.domain.models.Expense;
import com.example.PersonalFinanceAPI.domain.repositories.ExpenseRepository;

import java.util.Date;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public Expense saveExpense(String userId, String description, double amount, Date date, List<String> tags) {

        if (tags == null) {
            tags = List.of();
        }

        Expense newExpense = new Expense(userId, description, amount, date, tags);
        this.expenseRepository.save(newExpense);
        return newExpense;
    }
}
