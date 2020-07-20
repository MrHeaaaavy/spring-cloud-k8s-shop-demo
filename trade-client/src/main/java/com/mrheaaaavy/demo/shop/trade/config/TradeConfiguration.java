package com.mrheaaaavy.demo.shop.trade.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Collections;

public class TradeConfiguration {

    @Bean
    public Decoder decoder() {
        return new JacksonDecoder(new ArrayList<>(Collections.singleton(new JavaTimeModule())));
    }

    @Bean
    public Encoder encoder() {
        return new JacksonEncoder();
    }
}
