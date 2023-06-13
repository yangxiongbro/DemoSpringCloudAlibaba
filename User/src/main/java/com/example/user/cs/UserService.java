package com.example.user.cs;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.UserPO;
import com.example.user.cs.interfaces.IUserService;
import com.example.user.mapper.IUserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<IUserMapper, UserPO> implements IUserService {
}
