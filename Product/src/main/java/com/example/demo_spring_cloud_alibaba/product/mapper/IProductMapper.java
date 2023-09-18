package com.example.demo_spring_cloud_alibaba.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo_apring_cloud_alibaba.common.po.product.ProductPO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IProductMapper extends BaseMapper<ProductPO> {

}