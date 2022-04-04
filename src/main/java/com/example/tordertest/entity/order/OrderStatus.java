package com.example.tordertest.entity.order;

import lombok.Getter;

@Getter
public enum OrderStatus {

    NOTPAID, //미결제
    PAID;  //결제

}
