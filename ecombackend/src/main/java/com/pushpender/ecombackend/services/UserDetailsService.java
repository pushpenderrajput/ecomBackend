package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.UserDTO.UserDetailDto;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    public UserDetailDto userByUsername(String username){
        var user = userRepo.findByEmail(username);
        UserDetailDto newUSer = new UserDetailDto();
        newUSer.setName(user.getName());
        newUSer.setPassword(user.getPassword());
        newUSer.setRole(user.getRole());
        return newUSer;
    }
    public UserDetailDto userById(Long userId){
        var user = userRepo.findById(userId).orElse(null);
        if(user == null){
            throw new RuntimeException("User not Found!");
        }
        UserDetailDto newUSer = new UserDetailDto();
        newUSer.setName(user.getName());
        newUSer.setPassword(user.getPassword());
        newUSer.setRole(user.getRole());
        return newUSer;
    }
}
