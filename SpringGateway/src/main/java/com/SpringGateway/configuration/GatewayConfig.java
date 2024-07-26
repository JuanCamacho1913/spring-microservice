package com.SpringGateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
//    @Bean
//    public RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder){
//        return routeLocatorBuilder.routes()
//                .route("course", course ->{
//                    return course.host("localhost")
//                                 .and()
//                                 .path("/v1/course/**")
//                                 .uri("lb://SPRING-COURSE");
//                })
//                .route("student", student ->{
//                    return student.host("localhost")
//                                  .and()
//                                  .path("/v1/student/**")
//                                  .uri("lb://SPRING-STUDENT");
//                })
//                .build();
//    }
}
