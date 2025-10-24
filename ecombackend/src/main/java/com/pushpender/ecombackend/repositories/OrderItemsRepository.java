package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepository extends JpaRepository<OrderItem,Long> {
}
