package com.example.tordertest.entity.order;

import com.example.tordertest.entity.TimeStamped;
import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class Order extends TimeStamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    private int quantity;

    private OrderStatus orderStatus = OrderStatus.NOTPAID;

    @Builder
    public Order(Menu menu, User user, OrderStatus orderStatus) {
        this.menu = menu;
        this.user = user;
    }

    public void updateStatus(OrderStatus orderStatus){
        this.orderStatus = OrderStatus.PAID;
    }
}
