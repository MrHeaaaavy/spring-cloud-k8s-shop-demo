package com.mrheaaaavy.demo.shop.trade.client;

import com.mrheaaaavy.demo.shop.trade.config.TradeConfiguration;
import com.mrheaaaavy.demo.shop.trade.response.TradeListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "trade-service", url = "http://trade-service:8083", configuration = TradeConfiguration.class)
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public interface TradeClient {

    /**
     * List trades
     *
     * @return TradeListResponse
     */
    @GetMapping("/trades")
    TradeListResponse list();
}
