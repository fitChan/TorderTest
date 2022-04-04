package com.example.tordertest.controller;


import com.example.tordertest.dto.payment.PaymentRes;
import com.example.tordertest.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/paid")
public class PaymentController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Void> updatePaid(@RequestBody PaymentRes paymentRes){
        orderService.updatePaid(paymentRes);
        return ResponseEntity.created(URI.create("/api/paid")).build();
    }
}
