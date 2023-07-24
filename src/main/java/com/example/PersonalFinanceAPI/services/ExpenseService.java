package com.example.PersonalFinanceAPI.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.PersonalFinanceAPI.models.Expense;
import com.example.PersonalFinanceAPI.repositories.ExpenseRepository;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    public void saveExpense(String userId, String description, double amount) {
        Expense newExpense = new Expense("123", userId, description, amount);
        this.expenseRepository.save(newExpense);
    }
}
