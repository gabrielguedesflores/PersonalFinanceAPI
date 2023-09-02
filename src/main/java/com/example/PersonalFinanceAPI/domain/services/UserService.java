package com.example.PersonalFinanceAPI.domain.services;

import com.example.PersonalFinanceAPI.application.dto.response.CreateUserResponseDto;
import com.example.PersonalFinanceAPI.application.dto.response.UserResponseDto;
import com.example.PersonalFinanceAPI.domain.models.User;
import com.example.PersonalFinanceAPI.domain.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(String userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        return userOptional.orElse(null);
    }

    public User findUserByEmailAndPassword(String userEmail, String userPassword) {
        Optional<User> userOptional = userRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
        return userOptional.orElse(null);
    }

    public CreateUserResponseDto saveUser(String userName, String userEmail, String userPassword, Date userDateLastUpdated) {
        try {
            User newUser = new User(userName, userEmail, userPassword, userDateLastUpdated);
            User userResponse = this.userRepository.save(newUser);
            CreateUserResponseDto userDto = new CreateUserResponseDto();
            userDto.setUserName(userResponse.getUserName());
            userDto.setUserEmail(userResponse.getUserEmail());
            userDto.setUserPassword(userResponse.getUserPassword());
            userDto.setUserDateLastUpdated(userResponse.getUserDateLastUpdated());

            return userDto;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User updateUser(String userId, User user) {
        User userToUpdate = userRepository.findById(userId).orElse(null);

        if (userToUpdate == null) {
            return null;
        }

        if (user.getUserName() != null) {
            userToUpdate.setUserName(user.getUserName());
        }
        if (user.getUserEmail() != null) {
            userToUpdate.setUserEmail(user.getUserEmail());
        }
        if (user.getUserPassword() != null) {
            userToUpdate.setUserPassword(user.getUserPassword());
        }
        if (user.getUserDateLastUpdated() != null) {
            userToUpdate.setUserDateLastUpdated(user.getUserDateLastUpdated());
        }

        this.userRepository.save(userToUpdate);

        return userToUpdate; // Retorna o próprio objeto User após a atualização
    }

    public void deleteUser(String userId) {
        // Use the userRepository to delete the user by their userId
        userRepository.deleteById(String.valueOf(userId));
    }


}
