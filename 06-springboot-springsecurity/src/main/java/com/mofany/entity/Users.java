package com.mofany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2023/2/6
 * @description Users
 */
@Component
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Users implements Serializable {
    private Integer id;
    private String username;
    private String password;
}
