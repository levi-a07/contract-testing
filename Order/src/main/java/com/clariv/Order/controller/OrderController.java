package com.clariv.Order.controller;

import com.clariv.Order.model.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @GetMapping("/orders/{orderId}")
    public Order getOrder(@PathVariable String orderId){
        String productId ="product-1234";
        return Order.builder().quantity(2).price(29.99).productId(productId).orderId(orderId).build();
    }

}
