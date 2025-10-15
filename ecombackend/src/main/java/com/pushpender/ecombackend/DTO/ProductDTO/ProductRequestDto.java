package com.pushpender.ecombackend.DTO.ProductDTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequestDto {
    @NotNull
    @Size(min=3,max = 50)
    private String name;

    private String description;
    @NotNull
    private BigDecimal price;


}
