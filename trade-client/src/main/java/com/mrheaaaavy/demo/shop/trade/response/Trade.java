package com.mrheaaaavy.demo.shop.trade.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trade {
    private String tradeNo;
    private String customer;
    private LocalDateTime createdAt;
}
