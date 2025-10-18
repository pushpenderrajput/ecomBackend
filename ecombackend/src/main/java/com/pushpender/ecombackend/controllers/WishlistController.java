package com.pushpender.ecombackend.controllers;


import com.pushpender.ecombackend.DTO.WishlistDTO.WishlistRsponseDto;
import com.pushpender.ecombackend.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/wishlist")
public class WishlistController {
    @Autowired
    private WishlistService service;
    @GetMapping
    public List<WishlistRsponseDto> getWishlist(@PathVariable Long userId){
        return service.getWishlist(userId);
    }

    @PostMapping("/{prodId}")
    public void addWishlist(@PathVariable Long userId, @PathVariable Long prodId){
        service.addWishlist(userId,prodId);
    }

    @DeleteMapping("/{prodId}")
    public void deleteWishlist(@PathVariable Long userId, @PathVariable Long prodId){
        service.deleteWishlist(userId,prodId);
    }
}
