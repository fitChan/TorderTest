package com.example.tordertest.repository;

import com.example.tordertest.entity.order.OrderStatus;
import com.example.tordertest.entity.payment.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

//    List<Payment> findByOrderStatus(OrderStatus orderStatus);
}
