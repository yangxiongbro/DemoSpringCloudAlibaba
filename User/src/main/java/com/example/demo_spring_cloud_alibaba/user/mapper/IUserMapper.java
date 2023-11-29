package com.example.demo_spring_cloud_alibaba.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo_spring_cloud_alibaba.common.po.user.UserPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IUserMapper extends BaseMapper<UserPO> {

}
