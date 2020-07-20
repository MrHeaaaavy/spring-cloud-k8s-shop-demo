package com.mrheaaaavy.demo.shop.product.client;

import com.mrheaaaavy.demo.shop.product.config.ProductConfiguration;
import com.mrheaaaavy.demo.shop.product.response.ProductListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author mrheaaaavy
 */
@FeignClient(name = "product-service", url = "http://product-service:8082", configuration = {ProductConfiguration.class})
@RequestMapping(path = "/products", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public interface ProductClient {

    /**
     * Fetch products list
     *
     * @return product list response
     */
    @GetMapping("")
    ProductListResponse list();

}
