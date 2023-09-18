package com.example.demo_apring_cloud_alibaba.common.vo.product;

import lombok.Data;

@Data
public class ProductVO {
    private Long id;
    private String productName;
    private Integer status;
    private Double price;
    private String productDesc;
    private String caption;
    private Integer inventory;
}
