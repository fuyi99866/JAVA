package com.example.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringCloudApplication//等价于上面三个的组合注解 @SpringBootApplication+@EnableEurekaClient+@EnableCircuitBreaker
@EnableFeignClients//启用feign组件，内部集成了RestTemplate
public class ServerConsumer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServerConsumer1Application.class, args);
    }

}
