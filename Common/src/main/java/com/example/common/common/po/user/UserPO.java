package com.example.common.common.po.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_user")
public class UserPO {
    @TableId(type= IdType.AUTO)
    private Long id;
    private String username;
    private String password;
    private Integer age;
    private Double balance;//余额
    private String address;
}
