package com.mofany;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description MyApplication 启动类
 */
@MapperScan(basePackages = "com.mofany.mapper") // mapper接口扫描
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        /**
         * SpringApplication.run(MyApplication.class,args)与下面等价
         * */
        SpringApplication springApplication=new SpringApplication(MyApplication.class);
        springApplication.run(args);
    }
}
