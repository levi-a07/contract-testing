package com.clariv.contractTest;

import com.clariv.Order.controller.OrderController;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;


public  class BaseTestClass {

        @BeforeEach
        public void setup() {
            RestAssuredMockMvc.standaloneSetup(new OrderController());
        }
    }

