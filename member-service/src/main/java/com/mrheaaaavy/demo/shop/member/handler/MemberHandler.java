package com.mrheaaaavy.demo.shop.member.handler;

import com.mrheaaaavy.demo.shop.member.response.Member;
import com.mrheaaaavy.demo.shop.trade.client.TradeClient;
import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author mrheaaaavy
 */
@Component
public class MemberHandler {

    private final TradeClient tradeClient;

    public MemberHandler(TradeClient tradeClient) {
        this.tradeClient = tradeClient;
    }

    public Mono<ServerResponse> detail(ServerRequest request) {
        Flux<Trade> trades = tradeClient.list(1, 10);

        Mono<Member> memberMono = Mono.just(new Member().setName("member#1")).flatMap(member -> trades.collectList().map(member::setTrades));

        return ServerResponse.ok()
                .body(memberMono, Member.class);
    }

    public Mono<ServerResponse> list(ServerRequest request) {
        int page = request.queryParam("page").map(Integer::parseInt).orElse(1);
        int size = request.queryParam("size").map(Integer::parseInt).orElse(15);
        int start = (page - 1) * size;
        Flux<Member> memberFlux = Flux.range(start, size).map(integer -> new Member().setName("member#" + integer));

        return ServerResponse.ok()
                .body(memberFlux, Member.class);
    }

}
