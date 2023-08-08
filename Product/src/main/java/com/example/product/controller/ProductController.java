package com.example.product.controller;

import com.example.common.common.po.product.ProductPO;
import com.example.common.common.vo.product.ProductVO;
import com.example.product.service.interfaces.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Random;

@RequestMapping("/product")
@RestController
@RefreshScope
@Validated
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

    @PostMapping("checkout/{pid}")
    public ProductVO checkout(@PathVariable("pid") @NotNull Long pid, @RequestBody @NotNull @Min(1) Integer number) {
        return productService.checkout(pid,number);
    }
}
