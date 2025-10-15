package com.pushpender.ecombackend.DTO.UserDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto {

    @NotNull(message = "Name is Required!")
    private String name;
    @Email(message = "Please Enter Valid email Address!")
    private String email;
    @Size(min = 8,message = "Password must be larger than 8 Characters.")
    private String password;
}
