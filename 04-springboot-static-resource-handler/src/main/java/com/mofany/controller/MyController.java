package com.mofany.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MoFany-J
 * @date 2023/1/16
 * @description MyController
 */
@Controller
@RequestMapping(value = "api")
public class MyController {


    @GetMapping(value = "test/{id}")
    @ResponseBody
    public Map<String,Map<String,Object>> t1(@PathVariable(name = "id") String id){
        Map<String,Map<String,Object>> supMap=new HashMap<>();
        Map<String,Object> subMap=new HashMap<>();
        subMap.put("name","余华");
        supMap.put(id,subMap);
        return supMap;
    }
}
