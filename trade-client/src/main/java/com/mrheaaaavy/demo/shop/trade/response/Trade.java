package com.mrheaaaavy.demo.shop.trade.response;

import com.mrheaaaavy.demo.shop.product.response.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author mrheaaaavy
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Trade {

    public Trade(String tradeNo, String customer) {
        this.tradeNo = tradeNo;
        this.customer = customer;
        this.createdAt = LocalDateTime.now();
    }

    private String tradeNo;
    private String customer;
    private LocalDateTime createdAt;

    private List<Product> products;
}
