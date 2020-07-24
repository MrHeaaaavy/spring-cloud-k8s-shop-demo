package com.mrheaaaavy.demo.shop.member.config;

import com.mrheaaaavy.demo.shop.member.handler.MemberHandler;
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
public class MemberRouterConfig {

    private final MemberHandler memberHandler;

    public MemberRouterConfig(MemberHandler memberHandler) {
        this.memberHandler = memberHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> memberRoutes() {
        return RouterFunctions
                .route(GET("/members/detail").and(accept(MediaType.APPLICATION_JSON)), memberHandler::detail)
                .andRoute(GET("/members").and(accept(MediaType.APPLICATION_JSON)), memberHandler::list);
    }

}
