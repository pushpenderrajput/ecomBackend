package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}