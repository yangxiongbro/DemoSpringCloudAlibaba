package com.example.user.rs;

import com.example.common.common.po.UserPO;
import com.example.common.common.vo.UserVO;
import com.example.user.cs.interfaces.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
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
