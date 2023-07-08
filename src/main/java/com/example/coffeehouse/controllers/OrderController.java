package com.example.coffeehouse.controllers;

import com.example.coffeehouse.model.CoffeeOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("coffeeOrder")
public class OrderController {

    @GetMapping("/current")
    public String orderForm(){
        return "orderForm";
    }

    @PostMapping("/registry")
    public String processOrder(@ModelAttribute("coffeeOrder") @Valid CoffeeOrder coffeeOrder, Errors errors, SessionStatus sessionStatus) {
        if(errors.hasErrors()){
            log.debug(errors.getAllErrors().get(0).toString());
            return "orderForm";
        }
        log.info("Order submittes: {}", coffeeOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
