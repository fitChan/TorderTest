package com.example.tordertest.service.order;

import com.example.tordertest.dto.order.OrderRequest;
import com.example.tordertest.dto.order.OrderRequestList;
import com.example.tordertest.dto.order.OrderRes;
import com.example.tordertest.dto.payment.PaymentRes;
import com.example.tordertest.entity.menu.Menu;
import com.example.tordertest.entity.order.Order;
import com.example.tordertest.entity.order.OrderStatus;
import com.example.tordertest.entity.payment.Payment;
import com.example.tordertest.entity.user.User;
import com.example.tordertest.repository.MenuRepository;
import com.example.tordertest.repository.OrderRepository;
import com.example.tordertest.repository.PaymentRepository;
import com.example.tordertest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final MenuRepository menuRepository;
    private final PaymentRepository paymentRepository;

    // 요청받은 주문서 DB 저장
    @Transactional
    public void createOrder(OrderRequest orderRequest) {

        User user = userRepository.findById(orderRequest.getUserId()).orElseThrow(
                () -> new IllegalArgumentException("유저가 존재하지 않습니다.")
        );
        Menu menu = menuRepository.findById(orderRequest.getMenuId()).orElseThrow(
                () -> new IllegalArgumentException("")
        );

        Order order = Order.builder()
                .menu(menu)
                .user(user)
                .build();
        orderRepository.save(order);
    }


    //요청한 주문 조회
//    @Transactional
//    public List<OrderRes> getOrderList(Long userId) {
//        List<Order> orderList = orderRepository.findByUser(userId);
//        return OrderRes.list(orderList);
//    }
    @Transactional
    public List<OrderRes> getOrderList(Long userId) {
        List<Order> orderList = orderRepository.findByUserIdOrderByModifiedAtDesc(userId);
        return OrderRes.list(orderList);
    }

    //결제시 DB에서 삭제 할 것.
    @Transactional
    public List<OrderRes> getOrderNotPaidList(Long userId) {
        //유저 추가하기..
//        public List<OrderRes> paid(Long userId) {
//        List<Order> order = orderRepository.findByUserIdAndStatus(userId, OrderStatus.NOTPAID);
        List<Order> order = orderRepository.findByOrderStatusAndUserIdOrderByModifiedAtDesc(OrderStatus.NOTPAID , userId);
        return OrderRes.list(order);
    }

    @Transactional
    public void updatePaid(PaymentRes paymentRes) {
        Order orderId = orderRepository.findByOrderId(paymentRes.getOrderId());

        orderId.updateStatus(OrderStatus.PAID);
        Payment payment = Payment.builder()
                .order(orderId)
                .build();
        paymentRepository.save(payment);

    }


}
