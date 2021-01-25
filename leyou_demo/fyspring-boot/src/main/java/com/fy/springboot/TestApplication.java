package com.fy.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 引导类，springboot应用的入口
 */

//@EnableAutoConfiguration//启动自动配置
//@ComponentScan//类似于<context:component-scan base-package="">扫苗该类所在的包以及他的子子孙孙包
@SpringBootApplication//使用组合注解，相当于@SpringBootConfiguration+@EnableAutoConfiguration+@ComponentScan
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
