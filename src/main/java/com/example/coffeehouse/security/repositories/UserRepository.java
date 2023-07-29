package com.example.coffeehouse.security.repositories;


import com.example.authorizationserver.security.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {
    Users findByUsername(String username);
}
