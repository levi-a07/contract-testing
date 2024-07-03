package com.clariv.customer.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
    private String orderId;
    private String productId;
    private int quantity;
    private double price;

}
