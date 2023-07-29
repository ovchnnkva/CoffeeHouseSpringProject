package com.example.coffeehouse.messaging.controllers;

import com.example.coffeehouse.messaging.services.RabbitOrderMessagingService;
import com.example.coffeehouse.order.data.repositories.OrderRepository;
import com.example.coffeehouse.order.model.CoffeeOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(path="/orders", produces = "application/json")
@CrossOrigin(origins = "http://localhost:8080")
public class OrderApiController {
    private OrderRepository orderRepo;
    private RabbitOrderMessagingService messagingService;

    public OrderApiController(OrderRepository orderRepo, RabbitOrderMessagingService messagingService) {
        this.orderRepo = orderRepo;
        this.messagingService = messagingService;
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CoffeeOrder postOrder(@RequestBody CoffeeOrder coffeeOrder) {
        log.info("order-message send");
        messagingService.sendOrder(coffeeOrder);
        return orderRepo.save(coffeeOrder);
    }
}
