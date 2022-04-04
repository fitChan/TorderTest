package com.example.tordertest.dto.order;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderRequestList {

    private Long menuId;
//    private Long userId;
//    private int quantity;
}
