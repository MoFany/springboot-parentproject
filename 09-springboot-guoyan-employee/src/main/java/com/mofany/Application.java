package com.mofany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MoFany-J
 * @date 2023/2/10
 * @description Application
 */
@MapperScan(basePackages = "com.mofany.mapper") // mapper注解扫描
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
