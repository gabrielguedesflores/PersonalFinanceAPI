package com.example.PersonalFinanceAPI.repositories;
import com.example.PersonalFinanceAPI.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> { }
