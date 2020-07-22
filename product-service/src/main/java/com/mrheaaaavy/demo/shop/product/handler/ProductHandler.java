package com.mrheaaaavy.demo.shop.product.handler;

import com.mrheaaaavy.demo.shop.product.response.Product;
import com.mrheaaaavy.demo.shop.product.response.ProductListResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author mrheaaaavy
 */
@RestController
@RequestMapping(value = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class ProductHandler {

    @GetMapping
    public Mono<ProductListResponse> list() {
        Random random = new Random();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product(String.format("product#%d", i), random.nextInt()));
        }

        var resp = new ProductListResponse()
                .setPage(1)
                .setSize(15)
                .setTotal(10)
                .setProducts(products);

        return Mono.just(resp);
    }
}
