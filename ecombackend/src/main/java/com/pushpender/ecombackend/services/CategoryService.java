package com.pushpender.ecombackend.services;

import com.pushpender.ecombackend.DTO.CategoryDTO.CategoryRequestDto;
import com.pushpender.ecombackend.DTO.CategoryDTO.CategoryResponseDto;
import com.pushpender.ecombackend.DTO.ProductDTO.ProductResponseDto;
import com.pushpender.ecombackend.entities.Category;
import com.pushpender.ecombackend.repositories.CategoryRepository;
import com.pushpender.ecombackend.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository repo;
    @Autowired
    ProductRepository prodRepo;
    public List<CategoryResponseDto> getAllCategories(){
        return repo.findAll().stream()
                .map(cat->new CategoryResponseDto(cat.getId(),cat.getName())).collect(Collectors.toList());
    }

    public void saveCategory(CategoryRequestDto dto){
        var cat = new Category();
        cat.setName(dto.getName());
        repo.save(cat);

    }

    public List<ProductResponseDto> getProducts(Long cat_id){
        return prodRepo.findByCategoryId(cat_id).stream()
                .map(p->{
                    var cat = p.getCategory();
                    var catDto = new CategoryResponseDto(
                            cat.getId(),
                            cat.getName()
                    );
                    return new ProductResponseDto(
                            p.getName(),
                            p.getDescription(),
                            p.getPrice(),
                            catDto
                    );
                }).collect(Collectors.toList());


    }
    public void deleteCategory(Byte id){
        repo.deleteById(id);
    }
}
