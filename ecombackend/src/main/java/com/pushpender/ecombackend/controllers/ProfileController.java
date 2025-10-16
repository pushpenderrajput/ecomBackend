package com.pushpender.ecombackend.controllers;

import com.pushpender.ecombackend.DTO.ProfileDTO.ProfileRequestDto;
import com.pushpender.ecombackend.DTO.ProfileDTO.ProfileResponseDto;
import com.pushpender.ecombackend.entities.Profile;
import com.pushpender.ecombackend.services.ProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/{id}/profile")
public class ProfileController {
    @Autowired
    private ProfileService service;
    @GetMapping
    public ProfileResponseDto getProfile(@PathVariable Long id){
        return service.getProfile(id);

    }
    @PostMapping void saveProfile(@RequestBody @Valid ProfileRequestDto profile, @PathVariable Long id){
        service.saveProfile(profile,id);
    }
}
