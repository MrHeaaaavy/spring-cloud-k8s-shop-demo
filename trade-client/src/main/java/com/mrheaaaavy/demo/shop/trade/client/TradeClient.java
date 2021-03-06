package com.mrheaaaavy.demo.shop.trade.client;

import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author mrheaaaavy
 */
@Component
public class TradeClient {

    private final WebClient webClient = WebClient.builder()
            .baseUrl("http://trade-service:8083")
            .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
            .build();

    /**
     * List trades
     *
     * @param page Page
     * @param size Size
     * @return TradeListResponse
     */
    public Flux<Trade> list(@RequestParam int page, @RequestParam int size) {
        return webClient.get()
                .uri(builder -> builder.path("/trades").queryParam("page", page).queryParam("size", size).build())
                .retrieve()
                .bodyToFlux(Trade.class);
    }
}
