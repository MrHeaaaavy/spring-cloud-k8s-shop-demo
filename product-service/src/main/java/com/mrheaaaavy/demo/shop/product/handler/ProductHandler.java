package com.mrheaaaavy.demo.shop.product.handler;

import com.mrheaaaavy.demo.shop.product.response.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author mrheaaaavy
 */
@RestController
@RequestMapping("/products")
public class ProductHandler {

    @GetMapping("")
    public List<Product> list(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "15") Integer size
    ) {
        int start = (page - 1) * size;

        Random random = new Random();
        Flux<Product> productFlux = Flux.range(start, size).map(i -> new Product("product#%d" + i, random.nextInt()));

        return productFlux.toStream().collect(Collectors.toList());
    }
}
