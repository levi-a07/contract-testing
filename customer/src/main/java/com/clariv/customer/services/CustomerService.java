package com.clariv.customer.services;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService {

    private final RestTemplate restTemplate;

    @Value("${producer.url}")
    private String producerUrl;

    public CustomerService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Order getOrder(String orderId) {
        System.out.println("Calling URL: " + producerUrl);
        return restTemplate.getForObject(producerUrl + "orders/" + orderId, Order.class);
    }
}