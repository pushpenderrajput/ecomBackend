package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}