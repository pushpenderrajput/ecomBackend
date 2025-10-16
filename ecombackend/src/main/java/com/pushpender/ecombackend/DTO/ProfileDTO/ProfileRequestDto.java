package com.pushpender.ecombackend.DTO.ProfileDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequestDto {
    @NotNull
    private String bio;
    @Size(min = 10,max = 10)
    @NotNull
    private String phoneNumber;

    private LocalDate dateOfBirth;
    private Integer loyaltyPoints;
}
