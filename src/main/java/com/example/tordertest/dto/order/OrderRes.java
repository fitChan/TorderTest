package com.example.tordertest.dto.order;

import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.order.Order;
import com.example.tordertest.entity.order.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class OrderRes {
    private Long orderId;
    private Long userId;
    private String menuName;
    private int price;
    private OrderStatus orderStatus;


    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "asia/seoul")
    @CreatedDate
    private LocalDateTime createdAt;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "asia/seoul")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Builder
    public OrderRes(Long orderId, String menuName,Long userId, int price,OrderStatus orderStatus, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.orderId = orderId;
        this.menuName = menuName;
        this.userId = userId;
        this.price = price;
        this.orderStatus = orderStatus;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static OrderRes of(Order order) {
        return OrderRes.builder()
                .orderId(order.getOrderId())
                .menuName(order.getMenu().getMenuName())
                .userId(order.getUser().getId())
                .price(order.getMenu().getPrice())
                .orderStatus(order.getOrderStatus())
                .createdAt(order.getCreatedAt())
                .modifiedAt(order.getModifiedAt())
                .build();
    }

    public static List<OrderRes> list(List<Order> orderList) {
        List<OrderRes> orderRes = new ArrayList<>();
        for (Order order : orderList) {
            orderRes.add(of(order));
        }
        return orderRes;
    }
}
