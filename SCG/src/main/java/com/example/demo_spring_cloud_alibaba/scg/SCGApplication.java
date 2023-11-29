package com.example.demo_spring_cloud_alibaba.scg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <b><code>SCGApplication</code></b>
 * <p/>
 * Spring Cloud Gateway
 * <p/>
 * <b>Creation Time:</b> 2023/11/28 22:52
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@EnableDiscoveryClient
public class SCGApplication {
    public static void main(String[] args) {
        SpringApplication.run(SCGApplication.class, args);
    }
}
