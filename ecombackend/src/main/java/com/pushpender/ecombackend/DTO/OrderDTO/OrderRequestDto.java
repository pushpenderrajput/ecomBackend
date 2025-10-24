package com.pushpender.ecombackend.DTO.OrderDTO;

import com.pushpender.ecombackend.DTO.ProductDTO.ProductRequestDto;
import com.pushpender.ecombackend.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class OrderRequestDto {
    @NotNull
    private Long userId;
    @NotNull
    private List<orderItemDto> products;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class orderItemDto{
        @NotNull
        private Long productId;
        @NotNull
        private Integer qty;
    }



}
