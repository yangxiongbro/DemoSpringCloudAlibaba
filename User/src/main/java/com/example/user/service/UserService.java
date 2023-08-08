package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.user.UserPO;
import com.example.common.common.vo.user.UserVO;
import com.example.user.service.interfaces.IUserService;
import com.example.user.mapper.IUserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<IUserMapper, UserPO> implements IUserService {

    public UserVO pay(Long uid, Double amount){
        UserVO userVO = new UserVO();
        UserPO userPO = getById(uid);
        if(null != userPO){
            userPO.setBalance(userPO.getBalance() - amount);
            updateById(userPO);
            BeanUtils.copyProperties(userPO, userVO);
        }
        return userVO;
    }
}
