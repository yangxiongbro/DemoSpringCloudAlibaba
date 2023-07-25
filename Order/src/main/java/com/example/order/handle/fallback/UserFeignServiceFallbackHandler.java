package com.example.order.handle.fallback;

import com.example.common.common.vo.UserVO;
import com.example.order.ms.UserFeignService;
import org.springframework.stereotype.Component;

/**
 * <b><code>UserFeignServiceFallback</code></b>
 * <p/>
 * 用户服务调用fallback
 * <p/>
 * <b>Creation Time:</b> 2023/7/25 23:19
 *
 * @author yang xiong
 * @since SpringCloudAlibaba 1.0
 */
@Component
public class UserFeignServiceFallbackHandler implements UserFeignService {
    @Override
    public UserVO findById(Long id) {
        System.out.println("UserFeignServiceFallback");
        return null;
    }
}
