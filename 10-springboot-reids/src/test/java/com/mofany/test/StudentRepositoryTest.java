package com.mofany.test;

import com.mofany.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author MoFany-J
 * @date 2023/2/22
 * @description StudentRepositoryTest
 */
@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 插入，存键值
     */
    @Test
    public void test1() {
        studentRepository.saveString("Content", "Hello Redis!");
    }

    /**
     * 读取，由键获取值
     */
    @Test
    public void test2() {
        studentRepository.getString("Content");
    }

}
