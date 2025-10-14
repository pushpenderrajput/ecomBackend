package com.pushpender.ecombackend.DTO.UserDTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {
    private String name;
    private String email;

}
