package com.pushpender.ecombackend.DTO.AddressDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponseDto {
    private String street;
    private String city;

    private String zip;

    private String state;


}
