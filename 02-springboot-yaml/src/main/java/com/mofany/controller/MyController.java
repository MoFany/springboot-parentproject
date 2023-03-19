package com.mofany.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MoFany-J
 * @date 2023/1/12
 * @description MyController
 */
@RestController
@RequestMapping(value = "api")
public class MyController {

    @GetMapping(value = "test1")
    @ResponseBody
    public Map<String,Object> requestHandler(){
        Map<String,Object> map=new HashMap<>();
        map.put("你好","SpringBoot");
        return map;
    }
}
