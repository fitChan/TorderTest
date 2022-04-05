package com.example.tordertest.controller;


import com.example.tordertest.dto.payment.PaymentRes;
import com.example.tordertest.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/paid")
public class PaymentController {
    private final OrderService orderService;


    // 결제 요청이 완료된 후 DB저장
    @PostMapping
    public ResponseEntity updatePaid(@RequestBody @Valid PaymentRes paymentRes, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors);
        }
        orderService.updatePaid(paymentRes);
        return ResponseEntity.created(URI.create("/api/paid")).build();
    }
}
