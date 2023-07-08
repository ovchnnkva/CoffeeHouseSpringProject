package com.example.coffeehouse.data.repositories;

import com.example.coffeehouse.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CoffeeOrder, Long> {

}
