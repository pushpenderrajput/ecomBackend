package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
