package com.example.tordertest.service.paymentService;

import com.example.tordertest.dto.payment.PaymentRes;
import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.order.Order;
import com.example.tordertest.entity.order.OrderStatus;
import com.example.tordertest.entity.payment.Payment;
import com.example.tordertest.repository.MenuRepository;
import com.example.tordertest.repository.OrderRepository;
import com.example.tordertest.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    private Long orderId;
    private String menuName;
    private int price;



}
