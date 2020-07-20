package com.mrheaaaavy.demo.shop.trade.handler;

import com.mrheaaaavy.demo.shop.trade.response.Trade;
import com.mrheaaaavy.demo.shop.trade.response.TradeListResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/trades", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class TradeHandler {

    @GetMapping("")
    public TradeListResponse list(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "15") int size) {
        int start = (page - 1) * size;
        int end = page * size;

        List<Trade> trades = new ArrayList<>();
        for (int i = start; i < end; i++) {
            trades.add(new Trade(String.format("trade-%d", i), String.format("customer-%d", i), LocalDateTime.now()));
        }

        return new TradeListResponse()
                .setPage(page)
                .setSize(size)
                .setTotal(Integer.MAX_VALUE)
                .setTrades(trades);
    }

}
