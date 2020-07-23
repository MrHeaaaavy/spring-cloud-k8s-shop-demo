package com.mrheaaaavy.demo.shop.product.handler;

import com.mrheaaaavy.demo.shop.product.response.Product;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

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
    public Flux<Product> list() {
        Random random = new Random();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product(String.format("product#%d", i).intern(), random.nextInt()));
        }

        return Flux.fromIterable(products);
    }
}
