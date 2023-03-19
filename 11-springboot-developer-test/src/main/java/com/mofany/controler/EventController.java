package com.mofany.controler;

import com.mofany.entity.CommonsResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description EventController 事件管理控制器
 */
@RestController
@RequestMapping("eventmanager")
public class EventController {
    /**
     * 增
     * */
    @PostMapping("create")
    public CommonsResult<Integer> create(){
        return null;
    }

    /**
     * 删与批量删
     * */
    @DeleteMapping("delete")
    public CommonsResult<Integer> delete(){
        return null;
    }

    /***
     * 改
     * */
    @PutMapping("update")
    public CommonsResult<Integer> update(){
        return null;
    }

    /**
     * 查
     * */
    @GetMapping("show")
    public CommonsResult<List> selete(){
        return null;
    }
}
