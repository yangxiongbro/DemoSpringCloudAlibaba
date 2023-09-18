package com.example.demo_spring_cloud_alibaba.order.handle.block;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * <b><code>SentinelResourceBlockHandlerClass</code></b>
 * <p/>
 * SentinelResourceBlockHandlerClass
 * <p/>
 * <b>Creation Time:</b> 2023/7/24 22:55
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
public class SentinelResourceBlockHandlerClass {

    public static String sentinelResource2BlockHandler(Integer id, BlockException blockException){
        return "sentinelResource2,被限流，id：" + id + "-BlockHandler";
    }
}
