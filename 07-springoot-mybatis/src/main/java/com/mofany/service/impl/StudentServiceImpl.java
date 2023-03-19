package com.mofany.service.impl;

import com.mofany.entity.Student;
import com.mofany.mapper.StudentMapper;
import com.mofany.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description StudentServiceImpl
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentMapper studentMapper;
    /**
     * 查询给定名称的学生
     *
     * @param student
     */
    @Override
    public List<Student> selectByName(Student student) {
        return studentMapper.selectByName(student);
    }
}
