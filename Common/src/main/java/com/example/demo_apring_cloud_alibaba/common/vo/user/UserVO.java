package com.example.demo_apring_cloud_alibaba.common.vo.user;

import lombok.Data;

@Data
public class UserVO {
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private Double balance;
    private String address;
}
