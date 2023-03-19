package com.mofany;

import com.mofany.autoconfig.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author MoFany-J
 * @date 2023/2/8
 * @description MyStarterTest
 */
@SpringBootTest
public class MyStarterTest {
    @Resource
    private DemoService demoService;

    @Test
    public void test1() {
        demoService.print();
    }

    @Test
    public void test2() {

        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("1"); // 底层构建一个新字符串11，但没有存入常量池
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);
    }
}
