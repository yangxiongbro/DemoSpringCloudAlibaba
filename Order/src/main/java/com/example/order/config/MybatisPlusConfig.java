package com.example.order.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>MybatisPlusConfig</code></b>
 * <p/>
 * mybatis-plus配置
 * <p/>
 * <b>Creation Time:</b> 2023/8/1 23:38
 *
 * @author yang xiong
 * @since SpringCloudAlibaba 1.0
 */
@Configuration
@MapperScan({"com.example.order.mapper"})
public class MybatisPlusConfig {
}
