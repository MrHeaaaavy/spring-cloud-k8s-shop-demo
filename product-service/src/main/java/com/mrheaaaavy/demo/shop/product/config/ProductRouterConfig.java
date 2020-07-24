package com.mrheaaaavy.demo.shop.product.config;

import com.mrheaaaavy.demo.shop.product.handler.ProductHandler;
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
public class ProductRouterConfig {

    private final ProductHandler productHandler;

    public ProductRouterConfig(ProductHandler productHandler) {
        this.productHandler = productHandler;
    }

    @Bean
    public RouterFunction<ServerResponse> productRoutes() {
        return RouterFunctions.route(GET("/products").and(accept(MediaType.APPLICATION_JSON)), productHandler::list);
    }

}
