package com.mrheaaaavy.demo.shop.member.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author mrheaaaavy
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class MemberListResponse {
    private int page;
    private int size;
    private int total;

    private List<Member> members;
}
