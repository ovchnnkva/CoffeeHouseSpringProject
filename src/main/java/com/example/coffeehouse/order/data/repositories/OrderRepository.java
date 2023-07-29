package com.example.coffeehouse.order.data.repositories;

import com.example.coffeehouse.order.model.CoffeeOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CoffeeOrder, Long> {

}
