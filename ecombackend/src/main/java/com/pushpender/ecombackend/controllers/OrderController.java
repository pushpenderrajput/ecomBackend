package com.pushpender.ecombackend.controllers;

import com.pushpender.ecombackend.DTO.OrderDTO.OrderRequestDto;
import com.pushpender.ecombackend.DTO.OrderDTO.OrderResponseDto;
import com.pushpender.ecombackend.DTO.OrderDTO.OrderStatusReqDto;
import com.pushpender.ecombackend.services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService service;
    @PostMapping("")
    public OrderResponseDto makeOrder(@RequestBody @Valid OrderRequestDto dto){
        return service.makeOrder(dto);
    }

    @GetMapping("/{orderId}")
    public OrderResponseDto orderById(@PathVariable Long orderId){
        return service.getOrderById(orderId);
    }

    @PatchMapping("/{orderId}/status")
    public void updateStatus(@PathVariable Long orderId, @RequestBody OrderStatusReqDto status){

        service.updateStatus(orderId,status.getStatus());
    }

}
