package com.example.order.ms;

import com.example.common.common.vo.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "Product", path = "/product/product")
public interface ProductFeignService {
    @GetMapping("/{id}")
    ProductVO findById(@PathVariable("id") Long id);
}
