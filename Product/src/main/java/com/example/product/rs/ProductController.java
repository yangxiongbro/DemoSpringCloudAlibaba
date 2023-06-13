package com.example.product.rs;

import com.example.common.common.po.ProductPO;
import com.example.common.common.vo.ProductVO;
import com.example.product.cs.interfaces.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/product")
@RestController
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("/{id}")
    public ProductVO findById(@PathVariable("id") Long id) {
        ProductVO productVO = new ProductVO();
        ProductPO productPO = productService.getById(id);
        if(null != productPO){
            BeanUtils.copyProperties(productPO, productVO);
        }
        return productVO;
    }
}
