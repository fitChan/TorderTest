package com.example.tordertest.dto.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
//    private List<OrderRequestList> orderRequestLists;

    private Long menuId;
    private Long userId;
//    private int quantity;

    /*
    private OrderStatus orderStatus;

    orderStatus는 결제하기 버튼 눌리면 알아서 Entity에서 Paid로 바뀌게 놔둘꺼야.
*/

}
