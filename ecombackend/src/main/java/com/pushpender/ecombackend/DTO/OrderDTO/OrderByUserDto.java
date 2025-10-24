package com.pushpender.ecombackend.DTO.OrderDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderByUserDto {
    private Long orderId;
    private BigDecimal total;
    private LocalDateTime date;
    private String status;
}
