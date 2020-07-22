package com.mrheaaaavy.demo.shop.member.handler;

import com.mrheaaaavy.demo.shop.member.response.Member;
import com.mrheaaaavy.demo.shop.trade.client.TradeClient;
import com.mrheaaaavy.demo.shop.trade.response.Trade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
@RequestMapping("/members")
public class MemberHandler {

    private final TradeClient tradeClient;

    public MemberHandler(TradeClient tradeClient) {
        this.tradeClient = tradeClient;
    }

    @GetMapping("/detail")
    public Mono<Member> detail() {
        Flux<Trade> trades = tradeClient.list(1, 18);
        var member = new Member().setName("#1");
        return Mono.just(member)
                .flatMap((Function<Member, Mono<Member>>) m -> trades.collectList().map((Function<List<Trade>, Member>) m::setTrades));
    }

    @GetMapping("")
    public Flux<Member> list() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            members.add(new Member().setName(String.format("member#%d", i)));
        }

        return Flux.fromIterable(members);
    }

}
