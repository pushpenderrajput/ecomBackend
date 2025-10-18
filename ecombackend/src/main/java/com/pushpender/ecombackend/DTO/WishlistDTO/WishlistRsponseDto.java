package com.pushpender.ecombackend.DTO.WishlistDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WishlistRsponseDto {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
}
