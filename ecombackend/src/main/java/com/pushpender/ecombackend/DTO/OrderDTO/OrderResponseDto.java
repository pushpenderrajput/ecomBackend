package com.pushpender.ecombackend.DTO.OrderDTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {

    private Long userId;
    private BigDecimal total;
    private LocalDateTime orderDate;
    private String status;
    private List<orderItems> items;
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class orderItems{
        private String name;
        private BigDecimal price;
        private Integer qty;

    }
}
