package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.ProductDTO.ProductRequestDto;
import com.pushpender.ecombackend.DTO.ProductDTO.ProductResponseDto;
import com.pushpender.ecombackend.entities.Product;
import com.pushpender.ecombackend.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    @Autowired
    private
    ProductRepository repo;

    public List<ProductResponseDto> getAllProducts(){
        return repo.findAll()
                .stream()
                .map(p->new ProductResponseDto(p.getName(),p.getDescription(),p.getPrice()))
                .collect(Collectors.toList());

    }

    public ProductResponseDto getProductById(Long id){
        return repo.findById(id)
                .map(p->new ProductResponseDto(p.getName(),p.getDescription(),p.getPrice()))
                .orElse(null);

    }

    public void saveProduct(ProductRequestDto dto){
        var product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        repo.save(product);

    }

    public void editProduct(ProductRequestDto dto, Long id){
        var  product = repo.findById(id).orElse(null);
        if(product == null){
            throw new RuntimeException("Product Not Found");
        }
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        repo.save(product);
    }

    public void deleteProduct(Long id){
        var product = repo.findById(id).orElse(null);
        if(product ==  null){
            throw new RuntimeException("Product not Found");

        }
        repo.deleteById(id);
    }
}
