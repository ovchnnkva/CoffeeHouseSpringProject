package com.example.coffeehouse.controllers;

import com.example.coffeehouse.data.repositories.OrderRepository;
import com.example.coffeehouse.data.repositories.UserRepository;
import com.example.coffeehouse.model.CoffeeOrder;
import com.example.coffeehouse.model.Users;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("coffeeOrder")
public class OrderController {

    private final OrderRepository orderRepository;

    private final UserRepository userRepo;

    public OrderController(OrderRepository orderRepository, UserRepository userRepo){
        this.orderRepository = orderRepository;
        this.userRepo = userRepo;
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
        log.info("Order submittes: {}", coffeeOrder);
        orderRepository.save(coffeeOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
