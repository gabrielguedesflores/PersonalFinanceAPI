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
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="expenses/v1")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @GetMapping(value = "/expense/{expenseId}")
    @Operation(summary = "Buscar uma despesa pelo ID")
    public ResponseEntity<Expense> findExpenseById(@PathVariable String expenseId) {
        Expense expense = this.expenseService.findExpenseById(expenseId);

        if (expense == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(expense);
    }

    @GetMapping(value = "/user/{userId}/expenses")
    @Operation(summary = "Buscar todas as despesas de um usuário")
    public ResponseEntity<List<ExpenseResponseDto>> findExpensesByUserId(@PathVariable String userId) {
        List<Expense> expenses = this.expenseService.findExpensesByUserId(userId);

        if (expenses.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<ExpenseResponseDto> responseDtos = expenses.stream()
                .map(expense -> new ExpenseResponseDto(
                        expense.getId(),
                        expense.getUserId(),
                        expense.getDescription(),
                        expense.getAmount(),
                        expense.getDate(),
                        expense.getTags()
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responseDtos);
    }

    @PostMapping(value = "/expense")
    @Operation(summary = "Cadastrar uma despesa")
    public ResponseEntity<Expense> createExpense(@RequestBody ExpenseRequestDto request) {
        String userId = request.getUserId();
        String description = request.getDescription();
        double amount = request.getAmount();
        List<String> tags = request.getTags();
        Date date = new Date();
        Expense expense = this.expenseService.saveExpense(userId, description, amount, date, tags);
        return ResponseEntity.status(HttpStatus.CREATED).body(expense);
    }

    @PutMapping(value = "/expense/{expenseId}")
    @Operation(summary = "Atualizar uma despesa")
    public ResponseEntity<ExpenseResponseDto> updateExpense(
            @PathVariable String expenseId,
            @RequestBody ExpenseRequestDto request
    ) {
        Expense existingExpense = this.expenseService.findExpenseById(expenseId);

        if (existingExpense == null) {
            return ResponseEntity.notFound().build();
        }

        // Verificar quais campos estão sendo enviados no request e atualizar apenas os que não são nulos
        if (request.getUserId() != null) {
            existingExpense.setUserId(request.getUserId());
        }
        if (request.getDescription() != null) {
            existingExpense.setDescription(request.getDescription());
        }
        if (request.getAmount() != 0.0) {
            existingExpense.setAmount(request.getAmount());
        }
        if (request.getDate() != null) {
            existingExpense.setDate(request.getDate());
        }
        if (request.getTags() != null) {
            existingExpense.setTags(request.getTags());
        }

        Expense updatedExpense = this.expenseService.saveExpense(existingExpense);
        ExpenseResponseDto responseDto = new ExpenseResponseDto(
                updatedExpense.getId(),
                updatedExpense.getUserId(),
                updatedExpense.getDescription(),
                updatedExpense.getAmount(),
                updatedExpense.getDate(),
                updatedExpense.getTags()
        );

        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping(value = "/expense/{expenseId}")
    @Operation(summary = "Excluir uma despesa")
    public ResponseEntity<String> deleteExpense(@PathVariable String expenseId) {
        boolean deleted = this.expenseService.deleteExpenseById(expenseId);

        if (deleted) {
            String responseJson = "{\"status\": \"OK\", \"message\": \"Despesa excluída com sucesso!\"}";
            return ResponseEntity.ok(responseJson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
