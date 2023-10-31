package com.example.demo_spring_cloud_alibaba.product.controller;

import com.example.demo_apring_cloud_alibaba.common.po.product.ProductPO;
import com.example.demo_apring_cloud_alibaba.common.vo.product.ProductVO;
import com.example.demo_spring_cloud_alibaba.product.service.interfaces.IProductService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Random;

@RequestMapping("/")
@RestController
@RefreshScope
@Validated
@Slf4j
public class ProductController {
    @Autowired
    private IProductService productService;

    private Random random = new Random();

    @GetMapping("/{id}")
    public ProductVO findById(@PathVariable("id") Long id) throws InterruptedException {
        log.info("seata xid ====================> {}", RootContext.getXID());
        ProductVO productVO = new ProductVO();
        ProductPO productPO = productService.getById(id);
        if(null != productPO){
            BeanUtils.copyProperties(productPO, productVO);
        }
        Thread.sleep(random.nextInt(1000));
        log.info("{}",productVO);
        return productVO;
    }

    @PostMapping("checkout/{pid}")
    public ProductVO checkout(@PathVariable("pid") @NotNull Long pid, @RequestBody @NotNull @Min(1) Integer number) {
        log.info("seata xid ====================> {}", RootContext.getXID());
        return productService.checkout(pid,number);
    }
}
