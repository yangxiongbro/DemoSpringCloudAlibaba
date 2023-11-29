package com.example.demo_spring_cloud_alibaba.common.enums.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <b><code>OrderEnum</code></b>
 * <p/>
 * 订单状态
 * <p/>
 * <b>Creation Time:</b> 2023/8/8 22:20
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */

@AllArgsConstructor
@Getter
public enum OrderStatusEnum {

    CREATED("CREATED", "已创建"),

    PAID("PAID", "已支付"),

    CANCELED("CANCELED", "已取消");

    private String status;

    private String name;
}
