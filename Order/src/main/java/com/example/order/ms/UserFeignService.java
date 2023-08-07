package com.example.order.ms;

import com.example.common.common.vo.UserVO;
import com.example.order.handle.fallback.UserFeignServiceFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "User", path = "/user/user", fallback = UserFeignServiceFallbackHandler.class)
public interface UserFeignService {
    @GetMapping("/{id}")
    UserVO findById(@PathVariable("id") Long id);

    @GetMapping("/pay")
    UserVO pay(@RequestParam("id") Long id, @RequestParam("amount") Double amount);

}