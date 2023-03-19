package com.mofany.mapper;

import com.mofany.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description StudentMapper
 */
@Repository
public interface StudentMapper {
    /**
     * 查询给定名称的学生
     * */
    List<Student> selectByName(Student student);
}
