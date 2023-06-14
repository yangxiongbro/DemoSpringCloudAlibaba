package com.example.order.ms;

import com.example.common.common.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "User", path = "/user/user")
public interface UserFeignService {
    @GetMapping("/{id}")
    UserVO findById(@PathVariable("id") Long id);
}