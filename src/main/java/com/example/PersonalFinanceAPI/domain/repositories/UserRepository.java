package com.example.PersonalFinanceAPI.domain.repositories;
import com.example.PersonalFinanceAPI.domain.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> { }
