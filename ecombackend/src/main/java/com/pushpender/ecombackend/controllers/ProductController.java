package com.pushpender.ecombackend.controllers;

import com.pushpender.ecombackend.DTO.ProductDTO.ProductRequestDto;
import com.pushpender.ecombackend.DTO.ProductDTO.ProductResponseDto;
import com.pushpender.ecombackend.entities.Product;
import com.pushpender.ecombackend.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("")
    public List<ProductResponseDto> getAllProducts(){
        return service.getAllProducts();

    }
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> getProductById(@PathVariable Long id){
        var product = service.getProductById(id);
        if(product == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);

    }
    @PostMapping("")
    public void saveProduct(@RequestBody @Valid ProductRequestDto dto){
        service.saveProduct(dto);

    }
    @PutMapping("/{id}")
    public void editProduct(@RequestBody @Valid ProductRequestDto dto, @PathVariable Long id){
        service.editProduct(dto,id);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        service.deleteProduct(id);
    }
}
