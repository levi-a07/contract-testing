package com.clariv.customer.service.service;


import com.clariv.customer.model.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureStubRunner(
        stubsMode = StubRunnerProperties.StubsMode.LOCAL,
        ids = "com.clariv:order:+:stubs:8080"
)
@TestPropertySource(locations = "classpath:application-junit.properties")
public class ConsumerContractTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldReturnOrder() {
        ResponseEntity<Order> response = restTemplate.getForEntity("http://localhost:8080/orders/1", Order.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Order order = response.getBody();

        assertThat(order).isNotNull();
        assertThat(order.getOrderId()).isEqualTo("1");
        assertThat(order.getProductId()).isEqualTo("product-1234");
        assertThat(order.getQuantity()).isEqualTo(2);
        assertThat(order.getPrice()).isEqualTo(29.99);

    }
}