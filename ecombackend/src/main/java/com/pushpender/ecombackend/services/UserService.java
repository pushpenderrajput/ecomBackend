package com.pushpender.ecombackend.services;

import com.pushpender.ecombackend.entities.User;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repo;

//    GET all Users
    public List<User> getUsers(){
        return (List<User>) repo.findAll();
    }
//    Create User
    public void saveUser(User user){
        repo.save(user);
    }
//  GET User by Id
    public User getUserById(Long id){
        return repo.findById(id).orElse(new User());
    }

//    Update User
    public void editUser(User user, Long id){
        User user1 = repo.findById(id).orElse(null);
//        assert user1 != null;
        if(user1.getId().equals(id)){
            repo.save(user);
        }

    }

//    Delete User
    public void deleteUser(Long id){
        User existing = repo.findById(id).orElse(null);
        if(existing == null){
            throw new RuntimeException("User not Exists");

        }
        repo.deleteById(id);
    }
}
