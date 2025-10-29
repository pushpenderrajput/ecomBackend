package com.pushpender.ecombackend.controllers;

import com.pushpender.ecombackend.DTO.AuthDTO.LoginRequestDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserRequestDto;
import com.pushpender.ecombackend.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public void registerUSer(@RequestBody UserRequestDto dto){
        authService.registerUser(dto);
    }
    @PostMapping("/login")
    public String userLogin(@RequestBody LoginRequestDto dto){
        return authService.userLogin(dto);
    }
}
