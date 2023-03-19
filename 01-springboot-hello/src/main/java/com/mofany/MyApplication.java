package com.mofany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author MoFany-J
 * @date 2023/1/11
 * @description MyApplication SpringBoot应用的入口
 */
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        //在main方法中运行一个SpringBoot应用
        SpringApplication.run(MyApplication.class,args);
    }
}
