package com.pushpender.ecombackend.controllers;


import com.pushpender.ecombackend.DTO.CategoryDTO.CategoryRequestDto;
import com.pushpender.ecombackend.DTO.CategoryDTO.CategoryResponseDto;
import com.pushpender.ecombackend.DTO.ProductDTO.ProductResponseDto;
import com.pushpender.ecombackend.services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;
    @GetMapping
    public List<CategoryResponseDto> getAllCategories(){
        return service.getAllCategories();
    }

    @PostMapping
    public void saveCategory(@RequestBody @Valid CategoryRequestDto dto){
        service.saveCategory(dto);
    }

    @GetMapping("/{id}/products")
    public List<ProductResponseDto> getProducts(@PathVariable Long cat_Id){
        return service.getProducts(cat_Id);
    }
    @PostMapping("/{id}")
    public void deleteCategory(@PathVariable Byte id){
        service.deleteCategory(id);
    }
}
