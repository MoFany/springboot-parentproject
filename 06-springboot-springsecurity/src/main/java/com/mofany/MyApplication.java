package com.mofany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description MyApplication
 */
@SpringBootApplication // SpringBoot启动类注解
@MapperScan("com.mofany.mapper") // MyBatisPlus所需的mapper接口扫描
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) // Spring Security注解支持
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class,args);
    }
}
