package com.example.tordertest.entity.payment;

import com.example.tordertest.entity.TimeStamped;
import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.order.Order;
import com.example.tordertest.entity.user.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Payment extends TimeStamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_id")
    private Long paymentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    /*
     * user를 받을 이유가 있는가?
     * Order에서 UserId를 타고 들어가 찾으면 되는것 아닌가?
     * payment 에서 userId랑 status가 NOTPAID인 애들만 찾으면 되는거 아닌가?(시간도 하루 안에서)
     * */


    @Builder
    public Payment( Order order) {
        this.order = order;
    }
}
