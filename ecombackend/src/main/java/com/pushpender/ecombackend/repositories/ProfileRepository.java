package com.pushpender.ecombackend.repositories;

import com.pushpender.ecombackend.entities.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}