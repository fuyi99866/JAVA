package com.fy.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
/**
 * 使用@Value注解，只能注入基本类型值
 * 在SpringBoot中，提供了一种新的属性注入方式，支持各种java基本数据类型及复杂类型的注入
 * 1、@Autowired注入
 * 2、构造函数注入
 * 3、@Bean方法的参数注入
 * 4、直接在@Bean方法上使用@Configuration(prefix="jdbc")
 */
@Configuration//声明一个类是一个JAVA配置类，相当于一个xml配置文件
//@PropertySource("classpath:jdbc.properties")//读取资源文件
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfiguration {
/*    @Value("com.mysql.jdbc.Driver")
    private String driverClassName;
    @Value("jdbc:mysql:127.0.0.1:3306/leyou")
    private String url;
    @Value("root")
    private String username;
    @Value("root")
    private String password;*/

    @Autowired
    private JdbcProperties jdbcProperties;//1、@Autowired注入

/*    public JdbcConfiguration(JdbcProperties jdbcProperties){//2、构造函数注入
        this.jdbcProperties = jdbcProperties;
    }*/

    @Bean//把方法的返回值注入到spring容器
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(this.jdbcProperties.getDriverClassName());
        druidDataSource.setUrl(this.jdbcProperties.getUrl());
        druidDataSource.setUsername(this.jdbcProperties.getUsername());
        druidDataSource.setPassword(this.jdbcProperties.getPassword());
        return druidDataSource;
    }

/*    @ConfigurationProperties(prefix = "jdbc")//4、直接在@Bean方法上使用@Configuration(prefix="jdbc")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        return druidDataSource;
    }*/
}
