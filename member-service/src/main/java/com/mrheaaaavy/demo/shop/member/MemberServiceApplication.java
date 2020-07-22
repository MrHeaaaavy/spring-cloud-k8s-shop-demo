package com.mrheaaaavy.demo.shop.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author mrheaaaavy
 */
@SpringBootApplication(scanBasePackages = {"com.mrheaaaavy.demo.shop"})
public class MemberServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MemberServiceApplication.class, args);
    }

}
