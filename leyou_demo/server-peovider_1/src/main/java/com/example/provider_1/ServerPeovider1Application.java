package com.example.provider_1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.provider_1.mapper")
@EnableEurekaClient
public class ServerPeovider1Application {

    public static void main(String[] args) {
        SpringApplication.run(ServerPeovider1Application.class, args);
    }

}
