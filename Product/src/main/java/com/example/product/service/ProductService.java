package com.example.product.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.common.po.product.ProductPO;
import com.example.common.common.vo.product.ProductVO;
import com.example.product.service.interfaces.IProductService;
import com.example.product.mapper.IProductMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends ServiceImpl<IProductMapper, ProductPO> implements IProductService {

    public ProductVO checkout(Long pid, Integer number){
        ProductVO productVO = new ProductVO();
        ProductPO productPO = getById(pid);
        if(null != productPO){
            productPO.setInventory(productPO.getInventory() - number);
            updateById(productPO);
            BeanUtils.copyProperties(productPO, productVO);
        }
        return productVO;
    }
}
