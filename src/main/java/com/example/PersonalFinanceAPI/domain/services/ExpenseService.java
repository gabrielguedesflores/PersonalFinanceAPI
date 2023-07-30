package com.example.PersonalFinanceAPI.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PersonalFinanceAPI.domain.models.Expense;
import com.example.PersonalFinanceAPI.domain.repositories.ExpenseRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public Expense findExpenseById(String expenseId) {
        Optional<Expense> expenseOptional = expenseRepository.findById(expenseId);
        return expenseOptional.orElse(null);
    }

    public List<Expense> findExpensesByUserId(String userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public boolean deleteExpenseById(String expenseId) {
        if (expenseRepository.existsById(expenseId)) {
            expenseRepository.deleteById(expenseId);
            return true;
        } else {
            return false;
        }
    }
}
