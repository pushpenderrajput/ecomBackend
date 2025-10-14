package com.pushpender.ecombackend.controllers;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.pushpender.ecombackend.entities.User;
import com.pushpender.ecombackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    @Autowired
    private UserService service;
//    Get All Users
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return service.getUsers();
    }

//    Get User By Id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }
//    Save a User
    @PostMapping("/users")
    public void saveUser(@RequestBody User user){
        service.saveUser(user);

    }
//   Update User
    @PutMapping("users/{id}")
    public void editUser(@RequestBody User user, @PathVariable Long id){
        service.editUser(user,id);
    }

//    Delete User
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }
}
