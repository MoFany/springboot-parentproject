package com.mofany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description Student
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@Component
public class Student {
    private Integer id;
    private String name;
    private String sex;
    private Short age;
}
