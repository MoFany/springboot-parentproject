package com.mofany.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author MoFany-J
 * @date 2023/1/15
 * @description Student
 */
@Getter
@ToString
@NoArgsConstructor
@Component
public class Student {
    /**
     * 读取配置属性值的方式2（使用这种方式的原理就是赋值无需setter方法，故内部为赋值）
     * */
    @Value("${student.id}")
    private Integer id;
    @Value("${student.name}")
    private String name;
    @Value("${student.sex}")
    private String sex;
    @Value("${student.age}")
    private Short age;
}
