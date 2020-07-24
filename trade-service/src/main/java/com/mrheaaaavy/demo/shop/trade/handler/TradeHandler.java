package com.mrheaaaavy.demo.shop.trade.handler;

import com.mrheaaaavy.demo.shop.product.client.ProductClient;
import com.mrheaaaavy.demo.shop.product.response.Product;
import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


/**
 * @author 杨振彪 <yangzhenbiao@gdmcmc.cn>
 */
@Component
public class TradeHandler {

    private final ProductClient productClient;

    public TradeHandler(ProductClient productClient) {
        this.productClient = productClient;
    }

    public Mono<ServerResponse> list(ServerRequest request) {
        int page = request.queryParam("page").map(Integer::parseInt).orElse(1);
        int size = request.queryParam("size").map(Integer::parseInt).orElse(15);
        int start = (page - 1) * size;

        Flux<Product> products = productClient.list();
        Flux<Trade> tradeFlux = Flux.range(start, size).flatMap(integer -> {
            Trade trade = new Trade("trade#%d" + integer, "customer#%d" + integer);
            return products.collectList().map(trade::setProducts);
        });

        return ServerResponse.ok()
                .body(tradeFlux, Trade.class);

    }
}
