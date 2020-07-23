package com.mrheaaaavy.demo.shop.trade.handler;

import com.mrheaaaavy.demo.shop.product.client.ProductClient;
import com.mrheaaaavy.demo.shop.product.response.Product;
import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


/**
 * @author mrheaaaavy
 */
@RestController
@RequestMapping(value = "/trades", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class TradeHandler {

    private final ProductClient productClient;

    public TradeHandler(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("")
    public Flux<Trade> list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int size) {
        int start = (page - 1) * size;

        Flux<Product> products = productClient.list();

        return Flux.range(start, size).flatMap((Function<Integer, Mono<Trade>>) integer -> {
            Trade trade = new Trade(String.format("trade#%d", integer).intern(), String.format("customer#%d", integer).intern());
            return products.collectList().map(trade::setProducts);
        });

    }
}
