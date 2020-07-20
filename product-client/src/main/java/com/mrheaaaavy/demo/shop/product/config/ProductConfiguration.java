package com.mrheaaaavy.demo.shop.product.config;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

public class ProductConfiguration {

    @Bean
    public Decoder decoder() {
        return new JacksonDecoder(Collections.singleton(new JavaTimeModule()));
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder(Collections.singleton(new JavaTimeModule()));
    }
}
