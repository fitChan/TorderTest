package com.example.tordertest.repository;

import com.example.tordertest.entity.order.Order;
import com.example.tordertest.entity.order.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@EnableJpaRepositories
public interface OrderRepository extends JpaRepository<Order, Integer> {

    Order findByOrderId(Long orderId);

    List<Order> findByOrderStatusAndUserIdOrderByModifiedAtDesc(OrderStatus orderStatus,Long userId);

    List<Order> findByUserIdOrderByModifiedAtDesc(Long userId);
}
