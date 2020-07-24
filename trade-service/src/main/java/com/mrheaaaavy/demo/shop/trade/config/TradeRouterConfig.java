package com.mrheaaaavy.demo.shop.trade.config;

import com.mrheaaaavy.demo.shop.trade.handler.TradeHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

/**
 * @author 杨振彪 <yangzhenbiao@gdmcmc.cn>
 */
@Configuration
public class TradeRouterConfig {

    private final TradeHandler tradeHandler;

    public TradeRouterConfig(TradeHandler tradeHandler) {
        this.tradeHandler = tradeHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> tradeRoutes() {
        return RouterFunctions
                .route(GET("/trades").and(accept(MediaType.APPLICATION_JSON)), tradeHandler::list);
    }

}
