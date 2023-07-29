package com.example.PersonalFinanceAPI.application.controllers.expense;
import com.example.PersonalFinanceAPI.application.dto.response.ExpenseResponseDto;
import com.example.PersonalFinanceAPI.domain.models.Expense;
import com.example.PersonalFinanceAPI.application.dto.request.ExpenseRequestDto;
import com.example.PersonalFinanceAPI.domain.services.ExpenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="expenses/v1")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    @Operation(summary = "Buscar todas despesa por usuário")
    public ResponseEntity<String> saveExpense() {
        String responseJson = "{\"status\": \"OK\", \"message\": \"Despesa retornada com sucesso!\"}";
        return ResponseEntity.status(HttpStatus.OK).body(responseJson);
    }

    @PostMapping(value = "/expense")
    @Operation(summary = "Cadastrar uma despesa")
    public ResponseEntity<ExpenseResponseDto> createExpense(@RequestBody ExpenseRequestDto request) {
        String userId = request.getUserId();
        String description = request.getDescription();
        double amount = request.getAmount();
        List<String> tags = request.getTags();

        Date date = new Date();

        Expense expense = this.expenseService.saveExpense(userId, description, amount, date, tags);
        ExpenseResponseDto responseDto = new ExpenseResponseDto(
                userId,
                description,
                amount,
                date,
                tags
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

}
