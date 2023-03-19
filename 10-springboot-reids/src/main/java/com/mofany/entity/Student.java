package com.mofany.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description Student 实体类
 */
@Setter
@Getter
@ToString
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String sex;
    private Short age;

    public Student() {
        super();
    }

    private Student(Integer id, String name, String sex, Short age) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
