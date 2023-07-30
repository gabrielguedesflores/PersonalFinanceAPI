package com.example.PersonalFinanceAPI.domain.repositories;
import com.example.PersonalFinanceAPI.domain.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'userId': ?0}")
    List<Expense> findByUserId(String userId);
}
