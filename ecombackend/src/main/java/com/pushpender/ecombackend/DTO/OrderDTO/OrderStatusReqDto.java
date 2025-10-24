package com.pushpender.ecombackend.DTO.OrderDTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderStatusReqDto {
    @NotNull
    private String status;
}
