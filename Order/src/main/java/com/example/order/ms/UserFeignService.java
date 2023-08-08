package com.example.order.ms;

import com.example.common.common.vo.user.UserVO;
import com.example.order.handle.fallback.UserFeignServiceFallbackHandler;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "User", path = "/user/user", fallback = UserFeignServiceFallbackHandler.class)
public interface UserFeignService {
    @GetMapping("/{uid}")
    UserVO findById(@PathVariable("uid") Long uid);

    @PostMapping("/pay/{uid}")
    UserVO pay(@PathVariable("uid") Long uid, @RequestBody Double amount);

}