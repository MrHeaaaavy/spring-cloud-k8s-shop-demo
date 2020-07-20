package com.mrheaaaavy.demo.shop.product.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ProductListResponse {
    private int page;
    private int size;
    private int total;

    private List<Product> products;
}
