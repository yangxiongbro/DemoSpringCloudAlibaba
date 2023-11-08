package com.example.demo_spring_cloud_alibaba.user.controller;

import com.common.java.response.BaseResponse;
import com.common.java.response.R;
import com.example.demo_apring_cloud_alibaba.common.po.user.UserPO;
import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.user.service.interfaces.IUserService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@RequestMapping("/")
@RestController
@RefreshScope
@Validated
@Slf4j
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public BaseResponse findById(@PathVariable("id") Long id) {
        log.info("seata xid ====================> {}", RootContext.getXID());
        UserVO userVO = new UserVO();
        UserPO userPO = userService.getById(id);
        if(null != userPO){
            BeanUtils.copyProperties(userPO, userVO);
        }
        log.info("{}",userVO);
        return new R<>(userVO);
    }

    @PostMapping("/pay/{uid}")
    public BaseResponse pay(@PathVariable("uid") @NotNull Long uid, @RequestBody @NotNull @DecimalMin("0.01") Double amount){
        log.info("seata xid ====================> {}", RootContext.getXID());
        return new R<>(userService.pay(uid, amount));
    }
}
