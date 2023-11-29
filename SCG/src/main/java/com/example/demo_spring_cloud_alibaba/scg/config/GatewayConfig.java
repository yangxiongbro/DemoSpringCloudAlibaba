package com.example.demo_spring_cloud_alibaba.scg.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>GatewayConfig</code></b>
 * <p/>
 * 网关配置
 * <p/>
 * <b>Creation Time:</b> 2023/11/29 23:03
 *
 * @author yang xiong
 * @since DemoSpringCloudAlibaba 1.0
 */
//@Configuration
//public class GatewayConfig {
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("order_route",
//                        r -> r.path("/demo_spring_cloud_alibaba/order/**")
////                .filters(
////                        f -> f.circuitBreaker(c -> c.name("myCircuitBreaker").fallbackUri("forward:/inCaseOfFailureUseThis"))
////                                .rewritePath("/consumingServiceEndpoint", "/backingServiceEndpoint")
////                )
//                .uri("http://127.0.0.1:9006"))
//        .build();
//    }
//}
