package com.example.common.common.vo.user;

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
