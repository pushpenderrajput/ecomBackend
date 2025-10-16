package com.pushpender.ecombackend.DTO.ProfileDTO;

import com.pushpender.ecombackend.DTO.UserDTO.UserResponseDto;
import com.pushpender.ecombackend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponseDto {
    private String bio;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Integer loyaltyPoints;
    private UserResponseDto user;



}
