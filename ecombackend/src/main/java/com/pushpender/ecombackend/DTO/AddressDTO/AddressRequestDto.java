package com.pushpender.ecombackend.DTO.AddressDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequestDto {

    private String street;
    @NotNull
    private String zip;
    @NotNull
    private String city;
    @NotNull
    private String state;

}
