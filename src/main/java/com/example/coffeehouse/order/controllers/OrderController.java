package com.example.coffeehouse.order.controllers;

import com.example.coffeehouse.messaging.services.RabbitOrderMessagingService;
import com.example.coffeehouse.order.data.repositories.OrderRepository;
import com.example.coffeehouse.security.repositories.UserRepository;
import com.example.coffeehouse.order.model.CoffeeOrder;
import com.example.coffeehouse.security.model.Users;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("coffeeOrder")
public class OrderController {

    private final OrderRepository orderRepository;
    private final RabbitOrderMessagingService messagingService;


    public OrderController(OrderRepository orderRepository, RabbitOrderMessagingService messagingService){
        this.orderRepository = orderRepository;
        this.messagingService = messagingService;
    }

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping("/registryorder")
    public String processOrder(@ModelAttribute("coffeeOrder") @Valid CoffeeOrder coffeeOrder, Errors errors,
                               SessionStatus sessionStatus, @AuthenticationPrincipal Users user) {
        if(errors.hasErrors()){
            log.debug(errors.getAllErrors().get(0).toString());
            return "orderForm";
        }

        coffeeOrder.setUser(user);
        log.info("Order submits: {}", coffeeOrder);
        log.info("order-message send");
        messagingService.sendOrder(coffeeOrder);
        orderRepository.save(coffeeOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
