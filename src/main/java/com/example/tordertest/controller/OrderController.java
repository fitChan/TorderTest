package com.example.tordertest.controller;


import com.example.tordertest.dto.order.OrderRequest;
import com.example.tordertest.dto.order.OrderRes;
import com.example.tordertest.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("")
    public ResponseEntity<Void> createOrder(@RequestBody OrderRequest orderRequest) {
        orderService.createOrder(orderRequest);
        return ResponseEntity.created(URI.create("/api/order")).build();
    }

    @GetMapping("/{userId}") // 결제 유무에 상관없이 다 보여주는 것.
    public ResponseEntity<List<OrderRes>> getOrderList(@PathVariable Long userId){
        /*
         * AuthenticationPrincipal 사용 해서 userId Integer 로 받아서 userId대신 리턴 하기.
         * */
        return ResponseEntity.ok().body(orderService.getOrderList(userId));
    }

    @GetMapping("/payment/{userId}") //유저 추가할것. 결제가 아직 안된 리스트
    public ResponseEntity<List<OrderRes>> getOrderNotPaidList(@PathVariable Long userId){
        return ResponseEntity.ok().body(orderService.getOrderNotPaidList(userId));
    }
}
