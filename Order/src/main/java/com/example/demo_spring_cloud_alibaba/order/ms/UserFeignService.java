package com.example.demo_spring_cloud_alibaba.order.ms;

import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.order.handle.fallback.UserFeignServiceFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "User", path = "/demo_spring_cloud_alibaba/user", fallback = UserFeignServiceFallbackHandler.class)
public interface UserFeignService {
    @GetMapping("/{uid}")
    UserVO findById(@PathVariable("uid") Long uid);

    @PostMapping("/pay/{uid}")
    UserVO pay(@PathVariable("uid") Long uid, @RequestBody Double amount);

}