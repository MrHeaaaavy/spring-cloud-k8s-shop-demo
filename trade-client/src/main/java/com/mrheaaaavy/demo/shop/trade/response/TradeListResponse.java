package com.mrheaaaavy.demo.shop.trade.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class TradeListResponse {

    private int total;
    private int size;
    private int page;

    private List<Trade> trades;
}
