package com.mrheaaaavy.demo.shop.product.handler;

import com.mrheaaaavy.demo.shop.product.response.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Random;

/**
 * @author mrheaaaavy
 */
@Component
public class ProductHandler {

    public Mono<ServerResponse> list(ServerRequest request) {
        int page = request.queryParam("page").map(Integer::parseInt).orElse(1);
        int size = request.queryParam("size").map(Integer::parseInt).orElse(15);

        int start = (page - 1) * size;

        Random random = new Random();
        Flux<Product> productFlux = Flux.range(start, size).map(i -> new Product("product#%d" + i, random.nextInt()));

        return ServerResponse
                .ok()
                .body(productFlux, Product.class);
    }
}
