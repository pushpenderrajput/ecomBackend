package com.pushpender.ecombackend.controllers;

import com.pushpender.ecombackend.DTO.OrderDTO.OrderByUserDto;
import com.pushpender.ecombackend.DTO.OrderDTO.OrderResponseDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserRequestDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserResponseDto;
import com.pushpender.ecombackend.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService service;
//    Get All Users
    @GetMapping("/users")
    public List<UserResponseDto> getAllUsers(){
        return service.getUsers();
    }

//    Get User By Id
    @GetMapping("/users{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id){
        var user = service.getUserById(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(user);
    }
//    Save a User
    @PostMapping("/users")
    public void saveUser(@Valid @RequestBody UserRequestDto dto){
        service.saveUser(dto);

    }
//   Update User
    @PutMapping("users/{id}")
    public void editUser(@RequestBody UserRequestDto dto, @PathVariable Long id){
        service.editUser(dto,id);
    }

//    Delete User
    @DeleteMapping("users/{id}")
    public void deleteUser(@PathVariable Long id){
        service.deleteUser(id);
    }

    @GetMapping("users/{userId}/orders")
    public List<OrderByUserDto> getOrders(@PathVariable Long userId){
        return service.getOrders(userId);
    }
}
