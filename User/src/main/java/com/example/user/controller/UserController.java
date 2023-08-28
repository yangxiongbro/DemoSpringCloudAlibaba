package com.example.user.controller;

import com.example.common.common.po.user.UserPO;
import com.example.common.common.vo.user.UserVO;
import com.example.user.service.interfaces.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@RequestMapping("/user")
@RestController
@RefreshScope
@Validated
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public UserVO findById(@PathVariable("id") Long id) {
        UserVO userVO = new UserVO();
        UserPO userPO = userService.getById(id);
        if(null != userPO){
            BeanUtils.copyProperties(userPO, userVO);
        }
        System.out.println(userVO);
        return userVO;
    }

    @PostMapping("/pay/{uid}")
    public UserVO pay(@PathVariable("uid") @NotNull Long uid, @RequestBody @NotNull @DecimalMin("0.01") Double amount){
        return userService.pay(uid, amount);
    }
}
