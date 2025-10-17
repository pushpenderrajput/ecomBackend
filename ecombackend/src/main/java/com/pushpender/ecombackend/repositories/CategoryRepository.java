package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
}