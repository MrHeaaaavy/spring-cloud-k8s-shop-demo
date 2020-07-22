package com.mrheaaaavy.demo.shop.product.client;

import com.mrheaaaavy.demo.shop.product.response.Product;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;


/**
 * @author mrheaaaavy
 */
@Component
public class ProductClient {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://product-service:8082")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    /**
     * Fetch products list
     *
     * @return product list response
     */
    public Flux<Product> list() {
        return webClient.get().uri("/products").retrieve().bodyToFlux(Product.class);
    }

}
