package com.example.demo_spring_cloud_alibaba.order.handle.fallback;

import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.order.ms.UserFeignService;
import org.springframework.stereotype.Component;

/**
 * <b><code>UserFeignServiceFallback</code></b>
 * <p/>
 * 用户服务调用fallback
 * <p/>
 * <b>Creation Time:</b> 2023/7/25 23:19
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
@Component
public class UserFeignServiceFallbackHandler implements UserFeignService {
    @Override
    public UserVO findById(Long id) {
        System.out.println("UserFeignServiceFallback");
        return null;
    }

    @Override
    public UserVO pay(Long id, Double amount) {
        System.out.println("UserFeignServiceFallback");
        return null;
    }
}