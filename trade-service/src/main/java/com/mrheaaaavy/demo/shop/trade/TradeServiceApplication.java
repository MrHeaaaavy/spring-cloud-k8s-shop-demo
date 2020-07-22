package com.mrheaaaavy.demo.shop.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mrheaaaavy
 */
@SpringBootApplication(scanBasePackages = {"com.mrheaaaavy.demo.shop"})
public class TradeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeServiceApplication.class, args);
    }

}
