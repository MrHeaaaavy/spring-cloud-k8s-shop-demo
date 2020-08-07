package com.mrheaaaavy.demo.shop.member.handler;

import com.mrheaaaavy.demo.shop.member.response.Member;
import com.mrheaaaavy.demo.shop.trade.client.TradeClient;
import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author mrheaaaavy
 */
@RestController
@RequestMapping(path = "/members")
public class MemberHandler {

    private final TradeClient tradeClient;

    public MemberHandler(TradeClient tradeClient) {
        this.tradeClient = tradeClient;
    }

    @GetMapping(path = "/detail")
    public Member detail() {
        Flux<Trade> trades = tradeClient.list(1, 10);

        Mono<Member> memberMono = Mono.just(new Member().setName("member#1")).flatMap(member -> trades.collectList().map(member::setTrades));

        return memberMono.block();

    }

    @GetMapping("")
    public List<Member> list(
            @RequestParam(name = "page", defaultValue = "1") Integer page,
            @RequestParam(name = "size", defaultValue = "15") Integer size
    ) {
        int start = (page - 1) * size;
        Flux<Member> memberFlux = Flux.range(start, size).map(integer -> new Member().setName("member#" + integer));

        return memberFlux.toStream().collect(Collectors.toList());
    }

}
