package com.pushpender.ecombackend.services;


import com.pushpender.ecombackend.DTO.OrderDTO.OrderRequestDto;
import com.pushpender.ecombackend.DTO.OrderDTO.OrderResponseDto;
import com.pushpender.ecombackend.entities.Order;
import com.pushpender.ecombackend.entities.OrderItem;
import com.pushpender.ecombackend.entities.Product;
import com.pushpender.ecombackend.entities.User;
import com.pushpender.ecombackend.repositories.OrderRepository;
import com.pushpender.ecombackend.repositories.ProductRepository;
import com.pushpender.ecombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;



@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Autowired
    private ProductRepository productRepo;
    @Autowired
    private UserRepository userRepo;

    public OrderResponseDto makeOrder(OrderRequestDto dto){
        User user = userRepo.findById(dto.getUserId()).orElse(null);
        if(user == null){
            throw new RuntimeException("User not Found");
        }
        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");



        List<OrderItem> orderItems = dto.getProducts().stream().map(i->
                {
                    Product product = productRepo.findById(i.getProductId()).orElse(null);
                    if(product == null){
                        throw new RuntimeException("Item not Found");
                    }

                    OrderItem item = new OrderItem();
                    item.setOrder(order);
                    item.setProduct(product);
                    item.setQuantity(i.getQty());
                    item.setPrice(product.getPrice());
                    BigDecimal subtotal = product.getPrice().multiply(BigDecimal.valueOf(i.getQty()));
                    item.setSubtotal(subtotal);
                    return item;


                }).collect(Collectors.toList());
                BigDecimal total = orderItems.stream()
                .map(it->it.getPrice().multiply(BigDecimal.valueOf(it.getQuantity())))
                .reduce(BigDecimal.ZERO,BigDecimal::add);

        order.setTotalAmount(total);
        order.setOrderItems(orderItems);
        Order savedOrder = orderRepo.save(order);


        OrderResponseDto orderResponse = new OrderResponseDto();
        orderResponse.setUserId(user.getId());
        orderResponse.setTotal(savedOrder.getTotalAmount());
        orderResponse.setOrderDate(savedOrder.getOrderDate());
        orderResponse.setStatus(savedOrder.getStatus());


        var items = savedOrder.getOrderItems().stream()
                .map(item->{
                    OrderResponseDto.orderItems resItems = new OrderResponseDto.orderItems();
                    resItems.setName(item.getProduct().getName());
                    resItems.setPrice(item.getPrice());
                    resItems.setQty(item.getQuantity());
                    return resItems;
                }).collect(Collectors.toList());

                orderResponse.setItems(items);
                return orderResponse;


    }
    public OrderResponseDto getOrderById(Long orderId){
        Order order = orderRepo.findById(orderId).orElse(null);
        if(order == null){
            throw new RuntimeException("Order not Found");
        }
        OrderResponseDto orderResponse = new OrderResponseDto();
        orderResponse.setUserId(order.getUser().getId());
        orderResponse.setStatus(order.getStatus());
        orderResponse.setTotal(order.getTotalAmount());
        orderResponse.setOrderDate(order.getOrderDate());

        var items = order.getOrderItems().stream()
                .map(item->{
                    OrderResponseDto.orderItems resItem = new OrderResponseDto.orderItems();
                    resItem.setName(item.getProduct().getName());
                    resItem.setPrice(item.getPrice());
                    resItem.setQty(item.getQuantity());
                    return resItem;
                }).toList();
        orderResponse.setItems(items);
        return orderResponse;

    }

    public void updateStatus(Long orderId, String status){
        Order order = orderRepo.findById(orderId).orElse(null);
        if(order == null){
            throw new RuntimeException("Order not found!");
        }
        Order newOrder = new Order();
        newOrder.setStatus(status);
        newOrder.setOrderDate(order.getOrderDate());
        newOrder.setId(order.getId());
        newOrder.setUser(order.getUser());
        newOrder.setOrderItems(order.getOrderItems());
        newOrder.setTotalAmount(order.getTotalAmount());
        orderRepo.save(newOrder);

    }
}
