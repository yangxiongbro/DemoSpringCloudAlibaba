package com.example.product.controller;

import com.example.common.common.po.ProductPO;
import com.example.common.common.vo.ProductVO;
import com.example.product.service.interfaces.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RequestMapping("/product")
@RestController
@RefreshScope
public class ProductController {
    @Autowired
    private IProductService productService;

    private Random random = new Random();

    @GetMapping("/{id}")
    public ProductVO findById(@PathVariable("id") Long id) throws InterruptedException {
        ProductVO productVO = new ProductVO();
        ProductPO productPO = productService.getById(id);
        if(null != productPO){
            BeanUtils.copyProperties(productPO, productVO);
        }
        Thread.sleep(random.nextInt(1000));
        System.out.println(productVO);
        return productVO;
    }
}
