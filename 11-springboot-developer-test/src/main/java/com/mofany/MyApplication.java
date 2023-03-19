package com.mofany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description MyApplication
 */
@SpringBootApplication  // SpringBoot核心配置类，主启动类
@EnableTransactionManagement    // 开启声明式事务
@MapperScan("com.mofany.mapper")    // 接口扫描
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
