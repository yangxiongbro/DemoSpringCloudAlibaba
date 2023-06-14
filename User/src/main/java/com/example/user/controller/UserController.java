package com.example.user.controller;

import com.example.common.common.po.UserPO;
import com.example.common.common.vo.UserVO;
import com.example.user.service.interfaces.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
@RefreshScope
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
        return userVO;
    }
}
