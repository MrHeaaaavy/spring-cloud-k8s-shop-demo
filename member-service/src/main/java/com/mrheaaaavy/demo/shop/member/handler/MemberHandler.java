package com.mrheaaaavy.demo.shop.member.handler;

import com.mrheaaaavy.demo.shop.member.response.Member;
import com.mrheaaaavy.demo.shop.member.response.MemberDetailResponse;
import com.mrheaaaavy.demo.shop.trade.client.TradeClient;
import com.mrheaaaavy.demo.shop.trade.response.TradeListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
public class MemberHandler {

    private final TradeClient tradeClient;

    public MemberHandler(TradeClient tradeClient) {
        this.tradeClient = tradeClient;
    }

    @GetMapping("/detail")
    public MemberDetailResponse detail() {
        TradeListResponse tradeListResponse = tradeClient.list();

        return MemberDetailResponse.builder()
                .member(new Member("member#1"))
                .trades(tradeListResponse.getTrades())
                .build();
    }
}
