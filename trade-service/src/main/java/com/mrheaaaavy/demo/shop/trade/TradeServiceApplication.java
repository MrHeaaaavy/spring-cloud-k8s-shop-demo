package com.mrheaaaavy.demo.shop.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mrheaaaavy
 */
@EnableFeignClients(basePackages = {"com.mrheaaaavy.demo.shop.product.client"})
@SpringBootApplication
public class TradeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeServiceApplication.class, args);
    }

}
