package com.example.coffeehouse.messaging.services;

import com.example.coffeehouse.order.model.CoffeeOrder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessagingService{
    private final RabbitTemplate rabbit;

    @Autowired
    public RabbitOrderMessagingService(RabbitTemplate rabbit){
        this.rabbit = rabbit;
    }

    public void sendOrder(CoffeeOrder order) {
        rabbit.convertAndSend("queue", order);
    }
}
