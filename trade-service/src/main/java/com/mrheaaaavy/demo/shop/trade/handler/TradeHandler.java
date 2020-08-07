package com.mrheaaaavy.demo.shop.trade.handler;

import com.mrheaaaavy.demo.shop.product.client.ProductClient;
import com.mrheaaaavy.demo.shop.product.response.Product;
import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author 杨振彪 <yangzhenbiao@gdmcmc.cn>
 */
@RestController
@RequestMapping("/trades")
public class TradeHandler {

    private final ProductClient productClient;

    public TradeHandler(ProductClient productClient) {
        this.productClient = productClient;
    }

    @GetMapping("")
    public List<Trade> list(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "15") Integer size
    ) {
        int start = (page - 1) * size;

        Flux<Product> products = productClient.list();
        Flux<Trade> tradeFlux = Flux.range(start, size).flatMap(integer -> {
            Trade trade = new Trade("trade#%d" + integer, "customer#%d" + integer);
            return products.collectList().map(trade::setProducts);
        });

        return tradeFlux.toStream().collect(Collectors.toList());
    }
}
