//package com.example.order.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//// 默认访问地址
//// http://localhost:port/swagger-ui/index.html
//@Configuration
//public class SwaggerConfig {
//
//    Boolean swaggerEnabled = true;
//
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.OAS_30)
//                .apiInfo(apiInfo())
//                // 是否开启
//                .enable(swaggerEnabled)//true
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.order.controller"))
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("资源中心swagger业务")
//                //创建人
//                .contact(new Contact("yangxiongbro", "http://www.example.com", "yangxiongbro@163.com"))
//                .version("1.0")
//                .description("描述")
//                .build();
//    }
//}