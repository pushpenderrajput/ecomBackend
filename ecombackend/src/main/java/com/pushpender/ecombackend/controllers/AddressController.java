package com.pushpender.ecombackend.controllers;


import com.pushpender.ecombackend.DTO.AddressDTO.AddressRequestDto;
import com.pushpender.ecombackend.DTO.AddressDTO.AddressResponseDto;
import com.pushpender.ecombackend.services.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private AddressService service;
    @GetMapping("/api/users/{user_id}/address")
    public List<AddressResponseDto> getAddress(@PathVariable Long user_id){
        return service.getAddress(user_id);
    }

    @PostMapping("/api/users/{user_id}/address")
    public void saveAddress(@RequestBody @Valid AddressRequestDto dto, @PathVariable Long user_id){
        service.saveAddress(dto,user_id);
    }
    @PutMapping("/api/addresses/{id}")
    public void editAddress(@RequestBody @Valid AddressRequestDto dto, @PathVariable Long id){
        service.editAddress(dto,id);
    }

    @DeleteMapping("/api/addresses/{id}")
    public void deleteAddress(@PathVariable Long id){
        service.deleteAddress(id);
    }
}
