package com.example.PersonalFinanceAPI.domain.repositories;
import com.example.PersonalFinanceAPI.domain.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> { }
