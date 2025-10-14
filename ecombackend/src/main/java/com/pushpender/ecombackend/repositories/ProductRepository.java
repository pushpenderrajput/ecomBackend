package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}