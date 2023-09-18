package com.example.demo_spring_cloud_alibaba.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo_apring_cloud_alibaba.common.po.order.OrderPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IOrderMapper extends BaseMapper<OrderPO> {

}