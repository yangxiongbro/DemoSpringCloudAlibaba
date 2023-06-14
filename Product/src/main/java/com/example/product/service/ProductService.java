package com.example.product.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.ProductPO;
import com.example.product.service.interfaces.IProductService;
import com.example.product.mapper.IProductMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceImpl<IProductMapper, ProductPO> implements IProductService {
}
