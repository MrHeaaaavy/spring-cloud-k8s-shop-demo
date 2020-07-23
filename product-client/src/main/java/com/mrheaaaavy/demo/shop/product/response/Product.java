package com.mrheaaaavy.demo.shop.product.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author mrheaaaavy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String name;
    private int price;
}
