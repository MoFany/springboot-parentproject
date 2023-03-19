package com.mofany;

import com.mofany.entity.Student;
import com.mofany.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description StudentServiceImplTest
 */
@SpringBootTest
public class StudentServiceImplTest {
    @Autowired
    private StudentService studentService;
    @Autowired
    private Student student;

    @Test
    public void test1(){
        student.setName("海波东");
        studentService.selectByName(student).stream().forEach(System.out::println);
    }
}
