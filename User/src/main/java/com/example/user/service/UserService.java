package com.example.user.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.user.UserPO;
import com.example.user.service.interfaces.IUserService;
import com.example.user.mapper.IUserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<IUserMapper, UserPO> implements IUserService {
}
