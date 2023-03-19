package com.mofany.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author MoFany-J
 * @date 2023/2/14
 * @description CommonResult 响应结果,需要传给前端的东西
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {
    /**
     * 响应状态，2000为成功，3000为失败
     * */
    private Integer code;

    /**
     * 响应的消息
     * */
    private String message;
    /**
     * 响应的数据
     * */
    private T data;

    /**
     * 重载构造器的调用
     * */
    public CommonResult(Integer code,String Message){
        this(code,Message,null);
    }
}
