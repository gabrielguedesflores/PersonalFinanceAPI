package com.example.PersonalFinanceAPI.application.controllers.user;

import com.example.PersonalFinanceAPI.application.dto.request.LoginRequestDto;
import com.example.PersonalFinanceAPI.application.dto.request.UserRequestDto;
import com.example.PersonalFinanceAPI.application.dto.response.CreateUserResponseDto;
import com.example.PersonalFinanceAPI.application.dto.response.FindUserResponseDto;
import com.example.PersonalFinanceAPI.application.dto.response.UserResponseDto;
import com.example.PersonalFinanceAPI.domain.services.UserService;
import com.example.PersonalFinanceAPI.domain.models.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value="users/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{userId}")
    @Operation(summary = "Buscar um usuário pelo ID")
    public ResponseEntity<FindUserResponseDto> findUser(@PathVariable String userId) {
        User user = this.userService.findUserById(userId);
        FindUserResponseDto responseDto;

        responseDto = new FindUserResponseDto();
        if(user != null){
            responseDto.setStatus("SUCCESS");
            responseDto.setMessage("Usuário encontrado na base de dados.");
            responseDto.setUser(user);
        }else{
            responseDto.setStatus("ERROR");
            responseDto.setMessage("Usuário não encontrado na base de dados.");
        }

        return ResponseEntity.ok(responseDto);
    }


    @PostMapping(value = "/user")
    @Operation(summary = "Cadastrar um usuário")
    public ResponseEntity<CreateUserResponseDto> creteUser(@RequestBody UserRequestDto request) {
        String userName = request.getUserName();
        String userEmail = request.getUserEmail();
        String userPassword = request.getUserPassword();
        Date userDateLastUpdated = new Date(1234567890000L);

        CreateUserResponseDto user = this.userService.saveUser(userName, userEmail, userPassword, userDateLastUpdated);
        CreateUserResponseDto responseDto = new CreateUserResponseDto(
                userName,
                userEmail,
                userPassword,
                userDateLastUpdated
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    @PutMapping(value = "/user/{userId}")
    @Operation(summary = "Atualizar um usuário")
    public ResponseEntity<User> updateUser(
            @PathVariable String userId,
            @RequestBody UserRequestDto updateDto) {

        User userToUpdate = new User();
        userToUpdate.setUserName(updateDto.getUserName());
        userToUpdate.setUserEmail(updateDto.getUserEmail());
        userToUpdate.setUserPassword(updateDto.getUserPassword());
        userToUpdate.setUserDateLastUpdated(new Date());

        User updatedUser = this.userService.updateUser(userId, userToUpdate);

        if (updatedUser == null) {
            return ResponseEntity.notFound().build();
        }

        UserResponseDto responseDto = new UserResponseDto(
                updatedUser.getUserName(),
                updatedUser.getUserEmail(),
                updatedUser.getUserDateLastUpdated()
        );

        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping(value = "/user/{userId}")
    @Operation(summary = "Excluir um usuário")
    public ResponseEntity<Void> deleteUser(
            @PathVariable String userId
    ) {
        // Check if the user exists with the given userId
        User existingUser = this.userService.findUserById(userId);
        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        // Delete the user
        this.userService.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }

    //endpoint temporario para login, o login sera feito em um microservico usando kafka
    @PostMapping(value = "/login")
    @Operation(summary = "Realizar login do usuário")
    public ResponseEntity<FindUserResponseDto> loginUser(@RequestBody LoginRequestDto loginRequest) {
        String userEmail = loginRequest.getUserEmail();
        String userPassword = loginRequest.getUserPassword();

        User user = this.userService.findUserByEmailAndPassword(userEmail, userPassword);
        FindUserResponseDto responseDto = new FindUserResponseDto();
        responseDto = new FindUserResponseDto();

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        responseDto.setStatus("SUCCESS");
        responseDto.setMessage("Usuário encontrado na base de dados.");
        responseDto.setUser(user);

        return ResponseEntity.ok(responseDto);

    }


}
