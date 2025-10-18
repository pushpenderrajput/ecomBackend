package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.WishlistDTO.WishlistRsponseDto;
import com.pushpender.ecombackend.entities.Product;
import com.pushpender.ecombackend.repositories.CategoryRepository;
import com.pushpender.ecombackend.repositories.ProductRepository;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class WishlistService {

    @Autowired
    private ProductRepository prodRepo;
    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private UserRepository userRepo;



    public List<WishlistRsponseDto> getWishlist(Long userId){
        var user = userRepo.findById(userId).orElse(null);
        if(user == null){
            throw  new RuntimeException("User not found with id:"+userId);
        }
        var favProd = user.getFavoriteProducts();
        return favProd
                .stream()
                .map(product -> new WishlistRsponseDto(product.getId(), product.getName(), product.getDescription(), product.getPrice(), product.getCategory().getName()))
                .collect(Collectors.toList());


    }

    public void addWishlist(Long userId, Long prodId){
        var user = userRepo.findById(userId).orElse(null);
        if(user == null){
            throw new RuntimeException("User not found with id:"+userId);
        }
        var prod = prodRepo.findById(prodId).orElse(null);
        if(prod == null){
            throw new RuntimeException("Product not Found with id:"+prodId);
        }


        user.getFavoriteProducts().add(prod);
        userRepo.save(user);
    }

    public void deleteWishlist(Long userId,Long prodId){
        var user = userRepo.findById(userId).orElse(null);
        if(user == null){
            throw new RuntimeException("User not found with id:"+userId);
        }
        var prod = prodRepo.findById(prodId).orElse(null);
        if(prod == null){
            throw new RuntimeException("Product not Found with id:"+prodId);
        }

        user.getFavoriteProducts().remove(prod);
        userRepo.save(user);
    }
}
