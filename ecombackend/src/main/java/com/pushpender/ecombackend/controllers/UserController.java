package com.pushpender.ecombackend.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pushpender.ecombackend.DTO.UserDTO.UserRequestDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserResponseDto;
import com.pushpender.ecombackend.entities.User;
import com.pushpender.ecombackend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService service;
//    Get All Users
    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return service.getUsers();
    }

//    Get User By Id
    @GetMapping("{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        var user = service.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(user);
    }
//    Save a User
    @PostMapping
    public void saveUser(@Valid @RequestBody UserRequestDto dto){
        service.saveUser(dto);

    }
//   Update User
    @PutMapping("{id}")
    public void editUser(@RequestBody User user, @PathVariable Long id){
        service.editUser(user,id);
    }

//    Delete User
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
