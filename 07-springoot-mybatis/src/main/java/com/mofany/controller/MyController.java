package com.mofany.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description MyController
 */
@RestController
@RequestMapping("api")
public class MyController {

    private Map<String, Object> response = new HashMap<>();

    @PostMapping("test")
    public Map<String, Object> test() {
        response.put("Content", "");
        return response;
    }

}
