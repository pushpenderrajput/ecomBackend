package com.pushpender.ecombackend.DTO.UserDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailDto {
    private String name;
    private String email;
    private String password;
    private String role;
}
