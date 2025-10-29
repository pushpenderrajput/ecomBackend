package com.pushpender.ecombackend.services;

import com.pushpender.ecombackend.DTO.AuthDTO.LoginRequestDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserRequestDto;
import com.pushpender.ecombackend.entities.User;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;

    public void registerUser(UserRequestDto dto){
        if(userRepo.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email Already Registered!");
        }
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(hashedPassword);
        user.setRole(dto.getRole());
        if(dto.getRole() == null || dto.getRole().isBlank()){
            user.setRole("USER");
        }else{
            user.setRole(dto.getRole());
        }

        userRepo.save(user);
    }
    public String userLogin(LoginRequestDto dto){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(),dto.getPassword()));
        var user = userRepo.findByEmail(dto.getEmail());
        if(user == null){
            return "User Not Found";
        }
        String token = jwtService.generateToken(user);
        return token;
    }
}
