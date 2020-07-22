package com.mrheaaaavy.demo.shop.trade.response;

import com.mrheaaaavy.demo.shop.product.response.Product;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@Accessors(chain = true)
public class Trade {
    private String tradeNo;
    private String customer;
    private LocalDateTime createdAt;

    private List<Product> products;
}
