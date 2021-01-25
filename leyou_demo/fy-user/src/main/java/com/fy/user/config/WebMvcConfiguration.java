package com.fy.user.config;

import com.fy.user.interceptor.Myinterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 配置拦截器
 * 1、声明该类是一个JAVA配置类
 * 2、实现WebMvcConfigurer接口
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {
    @Autowired
    private Myinterceptor myinterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myinterceptor).addPathPatterns("/**");
    }
}
