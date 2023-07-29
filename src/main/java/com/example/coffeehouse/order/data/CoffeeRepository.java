package com.example.coffeehouse.order.data;

import com.example.coffeehouse.order.model.Coffee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoffeeRepository extends PagingAndSortingRepository<Coffee, Long>, CrudRepository<Coffee, Long> {
}
