package com.mofany.service;

import com.mofany.entity.Student;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description StudentService
 */
public interface StudentService {
    /**
     * 查询给定名称的学生
     * */
    List<Student> selectByName(Student student);
}
