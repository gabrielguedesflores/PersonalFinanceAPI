package com.example.PersonalFinanceAPI.controllers;
import com.example.PersonalFinanceAPI.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public String saveExpense() {
        String userId = "123";
        String description = "Descrição da Despesa";
        double amount = 109.93;

        System.out.println("Registro (expense) salvo: userId = " + userId);
        System.out.println("Registro (expense) salvo: description = " + description);
        System.out.println("Registro (expense) salvo: amount = " + amount);
        this.expenseService.saveExpense(userId, description, amount);
        return "true";
    }

}
