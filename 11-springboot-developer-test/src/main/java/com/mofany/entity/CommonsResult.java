package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description CommonsResult 响应实体
 */
@Setter
@Getter
@ToString
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CommonsResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonsResult(Integer code, String message) {
        this(code, message, null);
    }
}
