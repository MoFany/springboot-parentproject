package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author MoFany-J
 * @date 2023/1/11
 * @description MyController 自定义控制器类
 */
@RestController
@RequestMapping(value = "api")
public class MyController {
    @GetMapping(value = "hello")
    public String requestHandler(){
        return "Hello Spring Boot!";
    }
}
