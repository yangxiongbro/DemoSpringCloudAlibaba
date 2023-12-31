package com.example.demo_spring_cloud_alibaba.common.po.order;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.demo_spring_cloud_alibaba.common.enums.order.OrderStatusEnum;
import lombok.Data;

@Data
@TableName("tb_order")
public class OrderPO {
    @TableId(type= IdType.AUTO)
    private Long id;
    private Long userId;
    private Long productId;
    private Integer number;
    private Double price;
    private Double amount;//总额
    private OrderStatusEnum status;
}
