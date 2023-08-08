package com.example.order.ms;

import com.example.common.common.vo.product.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "Product", path = "/product/product")
public interface ProductFeignService {
    @GetMapping("/{id}")
    ProductVO findById(@PathVariable("id") Long id);

    @PostMapping("/checkout/{pid}")
    ProductVO checkout(@PathVariable("pid") Long pid, @RequestBody Integer number);
}
