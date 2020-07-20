package com.mrheaaaavy.demo.shop.member.response;

import com.mrheaaaavy.demo.shop.trade.response.Trade;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MemberDetailResponse {
    private Member member;
    private List<Trade> trades;
}
