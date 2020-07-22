package com.mrheaaaavy.demo.shop.member.response;

import com.mrheaaaavy.demo.shop.trade.response.Trade;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author mrheaaaavy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Member {
    private String name;
    private List<Trade> trades;
}
