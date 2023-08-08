package com.example.common.common.vo.order;

import com.example.common.common.enums.order.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderVO {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer number;
    private Double price;
    private Double amount;
    private OrderStatusEnum status;
}
