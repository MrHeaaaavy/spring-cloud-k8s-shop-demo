package com.mrheaaaavy.demo.shop.trade.response;

import com.mrheaaaavy.demo.shop.product.response.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private String tradeNo;
    private String customer;
    private LocalDateTime createdAt;

    private List<Product> products;
}
