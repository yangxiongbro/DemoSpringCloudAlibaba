package com.example.demo_spring_cloud_alibaba.user.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>MybatisPlusConfig</code></b>
 * <p/>
 * MybatisPlusConfig
 * <p/>
 * <b>Creation Time:</b> 2023/9/18 23:38
 *
 * @author yang xiong
 * @since SpringCloudAlibaba 1.0
 */
@Configuration
@MapperScan({"com.example.demo_spring_cloud_alibaba.user.mapper"})
public class MybatisPlusConfig {
}
