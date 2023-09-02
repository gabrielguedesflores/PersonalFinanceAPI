package com.example.PersonalFinanceAPI.domain.repositories;
import com.example.PersonalFinanceAPI.domain.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
