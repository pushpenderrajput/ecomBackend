package com.pushpender.ecombackend.DTO.ProductDTO;

import com.pushpender.ecombackend.DTO.CategoryDTO.CategoryResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class ProductResponseDto {

    private String name;
    private String description;
    private BigDecimal price;
    private CategoryResponseDto category;
}
