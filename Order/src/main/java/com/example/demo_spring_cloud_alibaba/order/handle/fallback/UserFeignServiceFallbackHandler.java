package com.example.demo_spring_cloud_alibaba.order.handle.fallback;

import com.common.java.response.R;
import com.example.demo_apring_cloud_alibaba.common.vo.user.UserVO;
import com.example.demo_spring_cloud_alibaba.order.ms.UserFeignService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class UserFeignServiceFallbackHandler implements UserFeignService {
    @Override
    public R<UserVO> findById(Long id) {
        log.info("UserFeignServiceFallbackHandler#findById fallback, id:{}", id);
        return null;
    }

    @Override
    public R<UserVO> pay(Long id, Double amount) {
        log.info("UserFeignServiceFallbackHandler#pay fallback, id:{}, amount:{}", id, amount);
        return null;
    }
}
