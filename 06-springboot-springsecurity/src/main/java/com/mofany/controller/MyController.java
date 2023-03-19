package com.mofany.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description MyController
 */
@RestController
@RequestMapping("api")
public class MyController {

    /**
     * 访问：/api/test时无需认证直接可以访问
     * */
    @GetMapping("logout")
    public String logout() {
        return "logout success!";
    }

    /**
     * 注解法权限认证
     * */
    @GetMapping("update")
    @Secured({"ROLE_root","ROLE_user"})
    public String update(){
        return "Hello update!";
    }

    /**
     * 方法执行前进行权限的认证，当登录用户具有admins权限后才能访问
     * */
    @GetMapping("insert")
    @PreAuthorize("hasAnyAuthority('admins','test')")
    public String insert(){
        return "Hello insert";
    }

    /**
     * 方法执行后进行权限的认证，当登录用户具有admins权限后才能访问
     * */
    @GetMapping("delete")
    @PostAuthorize("hasAnyAuthority('root')")
    public String delete(){
        System.out.println("delete......");
        return "Hello delete";
    }

}
