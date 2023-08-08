package com.example.product.service.interfaces;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.common.common.po.product.ProductPO;
import com.example.common.common.vo.product.ProductVO;

public interface IProductService extends IService<ProductPO> {

    /**
     * @description: 减库存
     * @param: pid - [Long]
     * @param: number - [Integer]
     * @return: com.example.common.common.vo.product.ProductVO
     * @throws
     * @author yang xiong
     * @date 2023/8/8 23:43
     **/
    ProductVO checkout(Long pid, Integer number);
}
