package com.example.demo_spring_cloud_alibaba.order.ms;

import com.common.java.response.R;
import com.example.demo_apring_cloud_alibaba.common.vo.product.ProductVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "Product", path = "/demo_spring_cloud_alibaba/product")
public interface ProductFeignService {
    @GetMapping("/{id}")
    R<ProductVO> findById(@PathVariable("id") Long id);

    @PostMapping("/checkout/{pid}")
    R<ProductVO> checkout(@PathVariable("pid") Long pid, @RequestBody Integer number);
}
