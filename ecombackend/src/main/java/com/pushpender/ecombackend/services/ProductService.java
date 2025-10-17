package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.CategoryDTO.CategoryResponseDto;
import com.pushpender.ecombackend.DTO.ProductDTO.ProductRequestDto;
import com.pushpender.ecombackend.DTO.ProductDTO.ProductResponseDto;
import com.pushpender.ecombackend.entities.Product;
import com.pushpender.ecombackend.repositories.CategoryRepository;
import com.pushpender.ecombackend.repositories.ProductRepository;
import jdk.jfr.Category;
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
    private ProductRepository repo;
    @Autowired
    private CategoryRepository catRepo;

    public List<ProductResponseDto> getAllProducts(){
        return repo.findAll().stream()
                .map(p->{
                    var category = p.getCategory();
                    var categoryDto = new CategoryResponseDto(
                            category.getId(),
                            category.getName()
                    );
                    return new ProductResponseDto(
                            p.getName(),
                            p.getDescription(),
                            p.getPrice(),
                            categoryDto
                    );
                })
                .collect(Collectors.toList());
    }

    public ProductResponseDto getProductById(Long id){
        return repo.findById(id)

                .map(p->{
                    var category = p.getCategory();
                    var categoryDto = new CategoryResponseDto(
                            category.getId(),
                            category.getName()
                    );
                    return new ProductResponseDto(
                            p.getName(),
                            p.getDescription(),
                            p.getPrice(),
                            categoryDto
                    );
                })
                .orElse(null);

    }

    public void saveProduct(ProductRequestDto dto){

        var cat = catRepo.findById(dto.getCategory()).orElse(null);
        if(cat == null){
            throw new RuntimeException("Category not Found with id:"+dto.getCategory());
        }
        var product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(cat);
        repo.save(product);

    }

    public void editProduct(ProductRequestDto dto, Long id){
        var  product = repo.findById(id).orElse(null);
        var cat = catRepo.findById(dto.getCategory()).orElse(null);
        if(product == null){
            throw new RuntimeException("Product Not Found with id:"+id);
        }
        if(cat == null){
            throw new RuntimeException("Category not found with id:"+dto.getCategory());
        }
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(cat);
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
