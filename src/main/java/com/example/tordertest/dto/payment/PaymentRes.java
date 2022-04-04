package com.example.tordertest.dto.payment;


import com.example.tordertest.entity.order.OrderStatus;
import com.example.tordertest.entity.payment.Payment;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PaymentRes {
    //    private Long userId;
    private Long orderId;

    //    private int totalPrice;

    @Builder
    public PaymentRes(Long orderId) {
        this.orderId = orderId;

    }


    public PaymentRes of(Payment payment) {
        return PaymentRes.builder()
                .orderId(payment.getOrder().getOrderId())
                .build();
    }

    public List<PaymentRes> list(List<Payment> paymentList){
        List<PaymentRes> paymentResList = new ArrayList<>();

        for(Payment payment : paymentList){
            paymentResList.add(of(payment));
        }
        return paymentResList;
    }
}
