package com.example.tordertest.controller;


import com.example.tordertest.dto.order.OrderRequest;
import com.example.tordertest.dto.order.OrderRes;
import com.example.tordertest.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    //주문한 내용들을 DB 저장
    @PostMapping("")
    public ResponseEntity createOrder(@RequestBody @Valid OrderRequest orderRequest, Errors errors) {
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(errors);
        }
        orderService.createOrder(orderRequest);
        return ResponseEntity.created(URI.create("/api/order")).build();
    }


    // 결제 유무에 상관없이 주문내역을 다 보여주는 것.
    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderRes>> getOrderList(@PathVariable Long userId){
        return ResponseEntity.ok().body(orderService.getOrderList(userId));
    }


    // 결제가 안된 주문내역만 보여주는 것.
    @GetMapping("/payment/{userId}")
    public ResponseEntity<List<OrderRes>> getOrderNotPaidList(@PathVariable Long userId){
        return ResponseEntity.ok().body(orderService.getOrderNotPaidList(userId));
    }
}
