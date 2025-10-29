package com.pushpender.ecombackend.services;

import com.pushpender.ecombackend.DTO.OrderDTO.OrderByUserDto;
import com.pushpender.ecombackend.DTO.OrderDTO.OrderResponseDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserRequestDto;
import com.pushpender.ecombackend.DTO.UserDTO.UserResponseDto;
import com.pushpender.ecombackend.entities.User;
import com.pushpender.ecombackend.repositories.OrderRepository;
import com.pushpender.ecombackend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
//    GET all Users
    public List<UserResponseDto> getUsers(){
        return repo.findAll().stream()
                .map(u->new UserResponseDto(u.getName(),u.getEmail()))
                .collect(Collectors.toList());
    }
//    Create User
    public void saveUser(UserRequestDto dto){
        if(repo.existsByEmail(dto.getEmail())){
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

        repo.save(user);
    }
//  GET User by Id
    public  UserResponseDto getUserById(Long id){
        return repo.findById(id)
                .map(u->new UserResponseDto(u.getName(),u.getEmail()))
                .orElse(null);
    }

//    Update User
    public void editUser(UserRequestDto dto, Long id){
        var user = repo.findById(id).orElse(null);
        if(user == null){
            throw new RuntimeException("User not Found");
        }
        user.setName(dto.getName());
        String hashedPassword = passwordEncoder.encode(dto.getPassword());
        user.setPassword(hashedPassword);
        user.setEmail(dto.getEmail());
        if(dto.getRole() == null || dto.getRole().isBlank()){
            if(user.getRole() == null || user.getRole().isBlank()){
                user.setRole("USER");
            }

        }else{
            user.setRole(dto.getRole());
        }

        repo.save(user);


    }

//    Delete User
    public void deleteUser(Long id){
        User existing = repo.findById(id).orElse(null);
        if(existing == null){
            throw new RuntimeException("User not Exists");

        }
        repo.deleteById(id);
    }

    public List<OrderByUserDto> getOrders(Long userId){
        var orders = orderRepo.findByUserId(userId);


        return orders.stream()
                .map(order-> {
                            OrderByUserDto resOrder = new OrderByUserDto();
                            resOrder.setOrderId(order.getId());
                            resOrder.setStatus(order.getStatus());
                            resOrder.setDate(order.getOrderDate());
                            resOrder.setTotal(order.getTotalAmount());
                            return resOrder;
                        }


                ).toList();
    }
}
